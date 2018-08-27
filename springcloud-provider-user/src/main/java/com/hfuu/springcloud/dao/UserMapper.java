package com.hfuu.springcloud.dao;

import com.hfuu.springcloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> list();

    User getBtId(Integer id);
}
