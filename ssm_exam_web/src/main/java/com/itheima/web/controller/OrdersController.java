package com.itheima.web.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.domain.Product;
import com.itheima.service.OrdersService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll")
    public String findAll(Model model, @RequestParam(name = "page",defaultValue = "1") Integer page,@RequestParam(name = "pageSize",defaultValue = "3") Integer pageSize){
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        System.out.println(ordersList);
         PageInfo<Orders> pageinfo = new PageInfo<Orders>(ordersList);

        model.addAttribute("pageinfo",pageinfo);
        return "orders-list";
    }
    @RequestMapping("/findOrdersById")
    public ModelAndView findOrdersById(String id){
        ModelAndView mv= new ModelAndView();
        Orders order = ordersService.findOrdersById(id);
        mv.addObject("orders",order);
        mv.setViewName("orders-show");
        return mv;
    }

}
