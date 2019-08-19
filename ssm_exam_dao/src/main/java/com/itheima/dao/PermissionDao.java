package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from PERMISSION where id in(select PERMISSIONID from ROLE_PERMISSION where ROLEID=#{roleid})")
    public List<Permission> findbypermissionid(String roleid);
    @Select("select * from PERMISSION")
    List<Permission> findAll();
    @Insert("insert into PERMISSION values(sys_guid(),#{permissionName},#{url})")
    void add(Permission permission);
}
