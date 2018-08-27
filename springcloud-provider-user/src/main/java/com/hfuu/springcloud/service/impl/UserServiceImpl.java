package com.hfuu.springcloud.service.impl;

import com.hfuu.springcloud.dao.UserMapper;
import com.hfuu.springcloud.entity.User;
import com.hfuu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
