package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

public interface SysLogService {
    void add(SysLog sysLog);

    List<SysLog> findAll(Integer page,Integer pageSize);
}
