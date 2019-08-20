package com.itheima.dao;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleDao {
    @Select("select * from ROLE where ID in (select ROLEID from USERINFO_ROLE where USERID=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "ID"),
            @Result(property = "roleName",column = "ROLENAME"),
            @Result(property = "roleDesc",column = "ROLEDESC"),
            @Result(property = "permissions",column = "ID",
                    many = @Many(select = "com.itheima.dao.PermissionDao.findbypermissionid"))
    })
    public List<Role> findbyRoleid(String id);

    @Select("select * from ROLE")
    List<Role> findAll();
    @Insert("insert into ROLE values(sys_guid(),#{roleName},#{roleDesc})")
    void add(Role role);
    @Select("select * from Role where ID=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "ID"),
            @Result(property = "roleName",column = "ROLENAME"),
            @Result(property = "roleDesc",column = "ROLEDESC"),
            @Result(property = "permissions",column = "ID",
                    many = @Many(select = "com.itheima.dao.PermissionDao.findbypermissionid"))
    })
    Role findById(String id);
    @Select("select p.*,nvl2(rp.PERMISSIONID,1,0) selected from PERMISSION P left join (select PERMISSIONID from ROLE_PERMISSION where ROLEID=#{roleId}) RP on P.ID = RP.PERMISSIONID")
    List<Permission> findAdditablePermission(String roleId);

    @Insert("insert into ROLE_PERMISSION values(#{id},#{roleId})")
    void addPermission(@Param("roleId") String roleId,@Param("id") String id);

    @Delete("delete from ROLE_PERMISSION where ROLEID = #{roleId}")
    void del(String roleId);

}
