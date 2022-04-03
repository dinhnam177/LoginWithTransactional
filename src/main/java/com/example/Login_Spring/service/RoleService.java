package com.example.Login_Spring.service;

import com.example.Login_Spring.reponsitory.IRoleReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    IRoleReponsitory iRoleReponsitory;
}
