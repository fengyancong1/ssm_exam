package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.dao.SysLogDao;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void add(SysLog sysLog) {
        sysLogDao.add(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return sysLogDao.findAll();
    }
}
