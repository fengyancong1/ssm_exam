package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.OrdersDao;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAll();
    }

    @Override
    public Orders findOrdersById(String id) {

        return ordersDao.findOrdersById(id);
    }
}
