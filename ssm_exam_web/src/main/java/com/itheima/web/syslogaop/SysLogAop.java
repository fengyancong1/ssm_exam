package com.itheima.web.syslogaop;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//@Component
//@Scope("prototype")
//@Aspect
public class SysLogAop {

    @Autowired
    private HttpServletRequest request;

    private Date startTime =new Date();

    @Autowired
    private SysLogService sysLogService ;

    //@Pointcut("execution(* com.itheima.web.controller.*.*(..))")
    public void logPt(){}

    //@Before("logPt()")
    public void beforeLog(){
        //记录用户开始执行时间
        startTime = new Date();
    }

// @AfterReturning("logPt()")
    public void afterReturningLog(JoinPoint joinPoint){
        Date endTime = new Date();

        //获取当前的访问用户
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        //获取用户的远程地址
        String addr = request.getRemoteAddr();
        //获取请求资源URL
        String uri = request.getRequestURI();
        //获取方法的执行时间
        Long millis = endTime.getTime()-startTime.getTime();
        //获取访问的方法名称
        String methodname = joinPoint.getSignature().getName();
        SysLog sysLog = new SysLog();
        sysLog.setVisitTime(startTime);
        sysLog.setUsername(name);
        sysLog.setIp(addr);
        sysLog.setUrl(uri);
        sysLog.setExecutionTime(millis);
        sysLog.setMethod(methodname);

        //调用业务层将数据保存到数据库
        sysLogService.add(sysLog);
        System.out.println(sysLog);
    }
}
