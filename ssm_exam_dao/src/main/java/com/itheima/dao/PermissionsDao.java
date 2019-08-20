package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionsDao {
    @Select("select * from PERMISSION where PID = #{id} ")
    public List<Permission> findbyid(String id);
}
