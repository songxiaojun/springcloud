package com.hfuu.springcloud.aops;


import com.hfuu.springcloud.annotion.LoggerManage;
import com.hfuu.springcloud.entity.LogEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;


/**
 * 日志管理 AOP
 */

@Aspect
@Component
public class LoggerAdvice {
    private Logger log =  LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long> startTime = new ThreadLocal<>();
    ThreadLocal<LogEntity> webLogThreadLocal = new ThreadLocal<>();

    @Pointcut("execution(* com.hfuu.springcloud..*.*(..))")
    public void serviceAspect(){

    }

    @Before("@annotation(loggerManage)")
    public void doBefore(JoinPoint joinPoint,LoggerManage loggerManage){
        // 接收到请求，记录请求内容
        log.info("执行: ==> [{}] 开始", loggerManage.description());

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容

        log.info("URL : " + request.getRequestURL().toString());

        log.info("HTTP_METHOD : " + request.getMethod());

        log.info("IP : " + request.getRemoteAddr());

        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

        //获取所有参数方法一：

        Enumeration<String> enu=request.getParameterNames();

        while(enu.hasMoreElements()){

            String paraName=(String)enu.nextElement();

            System.out.println(paraName+": "+request.getParameter(paraName));

        }
    }

    @AfterReturning(value = "@annotation(loggerManage)")
    public void addAfterReturningLogger(JoinPoint joinPoint, LoggerManage loggerManage) {
        log.info("执行: ==> [{}] 结束", loggerManage.description());
    }

}
