package com.itheima.dao;

import com.itheima.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductDao {
    @Select("select * from PRODUCT")
    public List<Product> findAll();

    @Insert("insert into product values(sys_guid(),#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void add(Product product);
    @Select("select * from PRODUCT where id=#{id}")
    public Product findbyid(String id);
    @Select("select * from PRODUCT where id=#{id}")
    Product findProductById(String id);
}
