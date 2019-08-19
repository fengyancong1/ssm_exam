package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
     public PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo =  userDao.findbyname(username);
        if (userInfo==null){
            return null;
        }

        List<Role>  roles = userInfo.getRoles();
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (Role role : roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==1?true:false,true,true,true,authorityList);

        return user;
    }

    @Override
    public List<UserInfo> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return userDao.findAll();
    }

    @Override
    public void add(UserInfo userInfo) {

        //设置密码加密
        String encode = passwordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encode);

       userDao.add(userInfo);
    }

    @Override
    public UserInfo findById(String id) {


        return userDao.findById(id);
    }

    @Override
    public List<Role> findAdditableRoles(String id) {

        return userDao.findAdditableRoles(id);
    }

    @Override
    public void addRole(String userid, String[] ids) {
        userDao.del(userid);
        if (ids!=null){
            for (String id : ids) {

                userDao.addRole(userid,id);
            }
        }

    }



}
