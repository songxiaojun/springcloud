package com.hfuu.springcloud.annotion;

import java.lang.annotation.*;

/**
 * sj
 * 2018-09-20
 * 控制器方法参数获取当前登录用户, 通过API token拦截实现, 如果不需要拦截, 则方法添加@IgnoreSecurityAuth注解
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}
