package com.hfuu.springcloud.controller;

import com.hfuu.springcloud.entity.User;
import com.hfuu.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getById/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public User getById(@PathVariable Integer id){
        User user = userService.getById(id);
        if (null == user) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return user;
    }

    public User processHystrix_Get(@PathVariable("id") Integer id)
    {
        return new User().setId(id).setName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }
}
