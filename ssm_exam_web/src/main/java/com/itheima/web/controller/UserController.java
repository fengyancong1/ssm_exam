package com.itheima.web.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize){
        List<UserInfo> userInfoList =  userService.findAll(page,pageSize);
        ModelAndView mv = new ModelAndView();
        PageInfo<UserInfo> pageinfo = new PageInfo<UserInfo>(userInfoList);
        mv.addObject("pageinfo",pageinfo);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/add")
    public String add(UserInfo userInfo){
        userService.add(userInfo);
        return "redirect:/user/findAll";
    }
    @RequestMapping("/findById")
    public String findById(Model model, @RequestParam (name = "id") String id){
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }
    @RequestMapping("/findAdditableRoles")
    public String findAdditableRoles(Model model,String id){
        List<Role> roles =  userService.findAdditableRoles(id);
        model.addAttribute("roleList",roles);
        model.addAttribute("userId",id);
        return "user-role-add";
    }
    @RequestMapping("/addRole")
    public String addRole(@RequestParam(name = "userid") String userid,@RequestParam(name = "ids") String[] ids){
        userService.addRole(userid,ids);
        return "redirect:/user/findAll";

    }
}
