package com.itheima.dao;

import com.itheima.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrdersDao {
    @Select("select * from ORDERS")
    @Results({
            @Result (property ="id",column = "id"),
            @Result (property ="orderNum",column = "orderNum"),
            @Result (property ="orderTime",column = "orderTime"),
            @Result (property ="orderStatus",column = "orderStatus"),
            @Result (property ="peopleCount",column = "peopleCount"),
            @Result (property ="orderDesc",column = "orderDesc"),
            @Result (property ="payType",column = "payType"),
            @Result (property ="product",column = "PRODUCTID",
                    one = @One(select = "com.itheima.dao.ProductDao.findbyid")
            )
    })
    public List<Orders> findAll();

    @Select("select * from ORDERS where id = #{id}")
    @Results({
            @Result ( property ="id",column = "id"),
            @Result (property ="orderNum",column = "orderNum"),
            @Result (property ="orderTime",column = "orderTime"),
            @Result (property ="orderStatus",column = "orderStatus"),
            @Result (property ="peopleCount",column = "peopleCount"),
            @Result (property ="orderDesc",column = "orderDesc"),
            @Result (property ="payType",column = "payType"),
            @Result (property ="product",column = "PRODUCTID",
                    one = @One(select = "com.itheima.dao.ProductDao.findbyid")
            ),
            @Result(property = "member",column = "MEMBERID",
                    one = @One(select = "com.itheima.dao.MemberDao.findbyMemberid")
            ),
            @Result(property = "travellerList",column = "ID",
            many = @Many(select = "com.itheima.dao.TravellerDao.findbyTravellerid")
            )

    })
    Orders findOrdersById(String id);
}
