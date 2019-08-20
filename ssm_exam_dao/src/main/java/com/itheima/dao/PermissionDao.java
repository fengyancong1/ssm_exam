package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PermissionDao {
    @Select("select * from PERMISSION where id in(select PERMISSIONID from ROLE_PERMISSION where ROLEID=#{roleid})")
    public List<Permission> findbypermissionid(String roleid);
    @Select("select * from PERMISSION")
    List<Permission> findAll();
    @Insert("insert into PERMISSION values(sys_guid(),#{permissionName},#{url})")
    void add(Permission permission);
    @Select("select * from PERMISSION where ID in(\n" +
            "  select\n" +
            "      p.PID\n" +
            "  from\n" +
            "      PERMISSION p , ROLE_PERMISSION rp , ROLE r ,USERINFO_ROLE ur , USERINFO u\n" +
            "  where\n" +
            "    p.ID = rp.PERMISSIONID and rp.ROLEID = r.ID and r.ID = ur.ROLEID and ur.USERID = u.ID and u.USERNAME = #{username}\n" +
            ")")
    List<Permission> findbyusername(String username);
    @Select("select * from PERMISSION where PID = #{id}  and  ID in (\n" +
            "  select\n" +
            "    rp.PERMISSIONID\n" +
            "  from\n" +
            "    ROLE_PERMISSION rp , ROLE r ,USERINFO_ROLE ur , USERINFO u\n" +
            "  where\n" +
            "    rp.ROLEID = r.ID and r.ID = ur.ROLEID and ur.USERID = u.ID and u.USERNAME = #{username}\n" +
            ")")
    List<Permission> findbyid(@Param("username") String username, @Param("id")  String id);
}
