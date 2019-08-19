package com.itheima.web.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize){
        List<Permission> permissionList = permissionService.findAll(page,pageSize);
        PageInfo<Permission> pageInfo  = new PageInfo<Permission>(permissionList);
        model.addAttribute("pageInfo",pageInfo);
        return "permission-list";
    }
    @RequestMapping("/add")
    public String add(Permission permission){
        permissionService.add(permission);
        return "redirect:/permission/findAll";
    }
}
