package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll(Integer page, Integer pageSize);

    void add(Permission permission);

    List<Permission> findbyusername(String username);

}
