package com.itheima.service;

import com.itheima.domain.Permission;
import com.itheima.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll(Integer page, Integer pageSize);

    void add(Role role);

    Role findById(String id);

    List<Permission> findAdditablePermission(String roleId);

    void addPermission(String roleId, String[] ids);
}
