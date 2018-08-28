package com.hfuu.springcloud.controller;

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

    @GetMapping("/getById/{id}")
    @ResponseBody
    public User getById(@PathVariable Integer id){
        User user = userService.getBtId(id);
        return user;
    }
}