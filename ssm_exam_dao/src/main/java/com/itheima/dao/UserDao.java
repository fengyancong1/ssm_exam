package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from USERINFO where USERNAME = #{username}")
    @Results({
            @Result(property = "id",column = "ID"),
            @Result(property = "username",column = "USERNAME"),
            @Result(property = "email",column = "EMAIL"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "phoneNum",column = "PHONENUM"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "ID",
                    many = @Many(select = "com.itheima.dao.RoleDao.findbyRoleid"))
    })
    UserInfo findbyname(String username);
    @Select("select * from USERINFO")
    List<UserInfo> findAll();

    @Select("insert into USERINFO  values(sys_guid(),#{email},#{username},#{password},#{phoneNum},#{status})")
    void add(UserInfo userInfo);

    @Select("select * from USERINFO where id = #{id}")
    @Results({
            @Result(property = "id",column = "ID"),
            @Result(property = "username",column = "USERNAME"),
            @Result(property = "email",column = "EMAIL"),
            @Result(property = "password",column = "PASSWORD"),
            @Result(property = "phoneNum",column = "PHONENUM"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "roles",column = "ID",
                    many = @Many(select = "com.itheima.dao.RoleDao.findbyRoleid"))
    })
    UserInfo findById(String id);
    //@Select("select * from ROLE where ID  not in (select ur.ROLEID from USERINFO u,USERINFO_ROLE UR where UR.USERID=#{id})")
    @Select("select r.*,nvl2(t.ROLEID,1,0) selected from ROLE R left join (select * from USERINFO_ROLE  where USERID=#{id}) t on R.ID = t.ROLEID")
    List<Role> findAdditableRoles(String id);

    @Insert("insert into USERINFO_ROLE values (#{userid},#{id})")
    void addRole(@Param("userid") String userid,@Param("id") String id);

    @Delete("delete from USERINFO_ROLE where USERID = #{userid}")
    void del(String userid);
}
