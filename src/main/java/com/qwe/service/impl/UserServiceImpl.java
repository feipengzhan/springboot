package com.qwe.service.impl;

import com.qwe.mapper.UserMapper;
import com.qwe.pojo.User;
import com.qwe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    public List<User> getAllUser() {
        return userMapper.selectAllUser();
    }
}
