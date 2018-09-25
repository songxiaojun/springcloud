package com.hfuu.springcloud.controller;

import com.hfuu.springcloud.entity.User;
import com.hfuu.springcloud.feign.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {
    @Autowired
    private UserClientService userClientService;

    @RequestMapping(value = "/movie/getById/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable("id") Long id) {
        User user = userClientService.getById(id);
        return user;
    }
}
