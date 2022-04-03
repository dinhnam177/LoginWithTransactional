package com.example.Login_Spring.reponsitory;

import com.example.Login_Spring.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleReponsitory extends JpaRepository<Role, String> {
}
