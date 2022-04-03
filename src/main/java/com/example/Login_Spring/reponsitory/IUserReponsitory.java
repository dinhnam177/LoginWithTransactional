package com.example.Login_Spring.reponsitory;

import com.example.Login_Spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserReponsitory extends JpaRepository<User,String> {

    @Query("SELECT u FROM User u WHERE u.username = :name AND u.password = :pass")
    User findOneUser(@Param("name") String name, @Param("pass") String pass);
    @Modifying
    @Query("update User u set u.fullname = :name where u.id = :id")
    void updateUser(@Param("id") int id, @Param("name") String name);
}
