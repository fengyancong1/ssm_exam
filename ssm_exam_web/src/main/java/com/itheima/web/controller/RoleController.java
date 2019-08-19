package com.itheima.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize){
        List<Role> roles =  roleService.findAll(page,pageSize);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        model.addAttribute("pageinfo",pageInfo);
        return "role-list";
    }
    @RequestMapping("/add")
    public String add(Role role){
         roleService.add(role);
         return "redirect:/role/findAll";
    }
    @RequestMapping("/findById")
    public String findById(Model model,@RequestParam(name = "roleId") String roleId){
        Role role = roleService.findById(roleId);
        model.addAttribute("role",role);
        return "role-show";
    }
    @RequestMapping("/findAdditablePermission")
    public String findAdditablePermission(Model model,@RequestParam(name = "roleId") String roleId){
        List<Permission> permissionList = roleService.findAdditablePermission(roleId);
        model.addAttribute("roleId",roleId);
        model.addAttribute("permissions",permissionList);
        return "role-permission-add";
    }
    @RequestMapping("/addPermission")
    public String addPermission( @RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids")String[] ids){
         roleService.addPermission(roleId,ids);
         return "redirect:/role/findAll";
    }
}
