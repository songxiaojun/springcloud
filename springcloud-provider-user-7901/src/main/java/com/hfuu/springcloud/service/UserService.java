package com.hfuu.springcloud.service;

import com.hfuu.springcloud.entity.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    List<User> list();

    User getById(Integer id);
}
