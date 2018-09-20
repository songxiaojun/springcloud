package com.hfuu.springcloud.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hfuu.springcloud.entity.User;


import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> list();

    User getBtId(Integer id);
}
