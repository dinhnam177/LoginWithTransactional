package com.example.Login_Spring.reponsitory;

import com.example.Login_Spring.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleReponsitory extends JpaRepository<UserRole, String> {
}
