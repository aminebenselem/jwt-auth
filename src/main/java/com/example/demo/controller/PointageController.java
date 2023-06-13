package com.example.demo.controller;

import com.example.demo.entity.Pointage;
import com.example.demo.entity.User;
import com.example.demo.repository.PointageDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PointageController {
    @Autowired
    private PointageDao pointageDao;
    @Autowired
    private UserService userService;


    public PointageController(PointageDao pointageDao) {
        this.pointageDao = pointageDao;
    }

    @PostMapping("/addpointage")
    public ResponseEntity<HttpStatus> addPointage(@RequestBody Pointage pointage){
        pointageDao.Pointage(pointage);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/monPointage")
    public ResponseEntity<List<Pointage>> getPointages(){
        User x=userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(x.getPointages(),HttpStatus.OK);
    }
}
