package com.itheima.service;


import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserInfo> findAll(Integer page, Integer pageSize);

    void add(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findAdditableRoles(String id);

    void addRole(String userid, String[] ids);
}
