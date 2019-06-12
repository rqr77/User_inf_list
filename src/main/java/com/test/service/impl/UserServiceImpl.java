package com.test.service.impl;

import com.test.domain.User;
import com.test.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserServiceImpl userdata=new UserServiceImpl();
    @Override
    public List<User> findAll() {
        //完成dao层

        return userdata.findAll();
    }

    @Override
    public void add(User user) {
        userdata.add(user);
    }
    @Override
    public void del(int id) {
        userdata.del(id);
    }
    @Override
    public User findById(int id) {
        return userdata.findById(id);
    }

    @Override
    public void update(User user){
        userdata.update(user);
    }

}
