package com.hfuu.springcloud.controller;

import com.hfuu.springcloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        return this.restTemplate.getForObject("http://localhost:7900/user/getById/"+id,User.class);
    }
}
