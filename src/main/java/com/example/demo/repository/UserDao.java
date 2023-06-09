package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    @Query(value = "select u from User u")
    public List<User> getAllUsers();

    @Query(value="select a from User a where a.Mat_Pers = ?1")
    public User findUser(String Mat_Pers);



}