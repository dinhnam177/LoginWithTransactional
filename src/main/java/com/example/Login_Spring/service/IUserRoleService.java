package com.example.Login_Spring.service;

import com.example.Login_Spring.domain.UserRole;

import java.util.List;

public interface IUserRoleService {
    List<UserRole> findAll();
}
