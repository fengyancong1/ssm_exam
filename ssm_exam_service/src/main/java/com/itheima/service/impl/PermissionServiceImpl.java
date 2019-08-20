package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.PermissionDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return permissionDao.findAll();
    }

    @Override
    public void add(Permission permission) {
        permissionDao.add(permission);
    }

    @Override
    public List<Permission> findbyusername(String username) {
        List<Permission> permissions = permissionDao.findbyusername(username);
        for (Permission permission : permissions) {
            List<Permission> list =  permissionDao.findbyid(username,permission.getId());
            permission.setPermissionList(list);
        }
        return permissions;
    }
}
