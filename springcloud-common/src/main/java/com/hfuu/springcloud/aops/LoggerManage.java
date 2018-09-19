package com.hfuu.springcloud.aops;

import java.lang.annotation.*;

/**
 * sj
 * 2018-09-19
 * 日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {
    public String description();
}
