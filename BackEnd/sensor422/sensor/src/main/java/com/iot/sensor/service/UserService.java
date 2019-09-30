package com.iot.sensor.service;

import com.iot.sensor.mapper.UserMapper;
import com.iot.sensor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User get(Long id) {
        List<User> users = userMapper.findByPrimaryId(id);

        if(users.size() == 1)
            return users.get(0);

        return null;
    }

    public User getByNumberAndName(String number, String name) {
        List<User> users = userMapper.findByNumberAndName(number, name);

        if(users.size() == 1)
            return users.get(0);

        return null;
    }
}
