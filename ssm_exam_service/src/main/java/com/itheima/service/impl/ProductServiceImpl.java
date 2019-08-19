package com.itheima.service.impl;

import com.itheima.dao.ProductDao;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Product> findAll() {

        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public Product findProductById(String id) {

        return productDao.findProductById(id);
    }
}
