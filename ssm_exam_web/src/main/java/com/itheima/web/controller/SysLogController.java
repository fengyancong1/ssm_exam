package com.itheima.web.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page",defaultValue = "1") Integer page, @RequestParam(name = "pageSize",defaultValue = "10") Integer pageSize){
        List<SysLog> sysLogs = sysLogService.findAll(page,pageSize);
        PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(sysLogs);
        model.addAttribute("pageInfo",pageInfo);
        return "syslog-list";
    }

}
