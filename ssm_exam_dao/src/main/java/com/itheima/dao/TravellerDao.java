package com.itheima.dao;

import com.itheima.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {
    @Select("select * from TRAVELLER where ID in (select TRAVELLERID from ORDER_TRAVELLER  where ORDERID=#{id})")
    public List<Traveller> findbyTravellerid(String id);
}
