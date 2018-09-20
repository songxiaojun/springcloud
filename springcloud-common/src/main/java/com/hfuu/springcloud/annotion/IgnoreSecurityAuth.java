package com.hfuu.springcloud.annotion;

import java.lang.annotation.*;

/**
 * sj
 * 2018-09-20
 * 1215817408@qq.com
 * 忽略API token拦截
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurityAuth {
}
