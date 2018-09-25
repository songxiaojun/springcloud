package com.hfuu.springcloud.feign;

import com.hfuu.springcloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER")
public interface UserClientService {
    @RequestMapping(value = "/user/getById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User getById(@PathVariable("id") Integer id);// 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
}
