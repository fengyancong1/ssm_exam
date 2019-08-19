package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.RoleDao;
import com.itheima.domain.Permission;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);

        return roleDao.findAll();
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Permission> findAdditablePermission(String roleId) {

        return  roleDao.findAdditablePermission(roleId);
    }

    @Override
    public void addPermission(String roleId, String[] ids) {
        roleDao.del(roleId);
        if (ids!=null){
            for (String id : ids) {
                roleDao.addPermission(roleId,id);
            }
        }
    }
}
