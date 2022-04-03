package com.example.Login_Spring.service;

import com.example.Login_Spring.domain.User;
import org.springframework.data.repository.query.Param;

public interface IUserService {
    void updateUser(int id,String name);
    User findOneUser(String name,String pass);
}
