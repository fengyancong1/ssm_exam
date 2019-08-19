package com.itheima.web.controller;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        List<Product> productList =  productService.findAll();
        ModelAndView mv= new ModelAndView();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/add")
    public String add(Product product){
        productService.add(product);
        return "redirect:/product/findAll";
    }
    @RequestMapping("findProductById")
    public ModelAndView findProductById(String id){
        Product product =  productService.findProductById(id);
        ModelAndView mv= new ModelAndView();
        mv.addObject("product",product);
        mv.setViewName("product-add");
        return mv;
    }
}
