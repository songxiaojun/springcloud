package com.hfuu.springcloud.controller;

import com.hfuu.springcloud.annotion.LoggerManage;
import com.hfuu.springcloud.entity.User;
import com.hfuu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    @ResponseBody
    public List<User> list(){

        List<User> list = userService.list();
        return list;
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    @LoggerManage(description = "测试")
    public User getById(@PathVariable("id") Integer id){
        User user = userService.getById(id);
        return user;
    }
}
