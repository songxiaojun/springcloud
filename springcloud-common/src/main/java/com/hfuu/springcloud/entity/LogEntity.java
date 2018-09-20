package com.hfuu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 日志打印实体
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class LogEntity {
    private long id;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求IP
     */
    private String ip;
    /**
     * 请求方式
     */
    private String httpMethod;
    /**
     * 请求类，方法
     */
    private String classMethod;
    /**
     * 方法参数
     */
    private String args;
    /**
     * 请求参数
     */
    private String reqParams;
    /**
     * 响应参数
     */
    private String respParams;
    /**
     * 响应时间
     */
    private long spendTime;
    /**
     * 日志类型（web、service）
     */
    private String logType;
    /**
     * 用户信息
     */
    private User user;

}
