package com.example.Login_Spring.service;

import com.example.Login_Spring.domain.UserRole;
import com.example.Login_Spring.reponsitory.IUserReponsitory;
import com.example.Login_Spring.reponsitory.IUserRoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    IUserRoleReponsitory iUserRoleReponsitory;

    @Override
    public List<UserRole> findAll() {
        return iUserRoleReponsitory.findAll();
    }
}
