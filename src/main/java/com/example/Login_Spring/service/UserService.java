package com.example.Login_Spring.service;

import com.example.Login_Spring.domain.User;
import com.example.Login_Spring.reponsitory.IUserReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserReponsitory iUserReponsitory;

    @Override
    public void updateUser(int id, String name) {
        iUserReponsitory.updateUser(id,name);
    }

    @Override
    public User findOneUser(String name, String pass) {
        return iUserReponsitory.findOneUser(name,pass);
    }
}
