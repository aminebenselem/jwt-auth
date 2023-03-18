package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userdao;


    public List<User> getAllUsers() {
        return userdao.getAllUsers();
    }

    public User getUser(String Mat_Pers) {
        return userdao.findUser(Mat_Pers);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

}