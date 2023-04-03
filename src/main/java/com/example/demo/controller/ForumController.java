package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.entity.Forum;
import com.example.demo.repository.EventDao;
import com.example.demo.repository.ForumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ForumController {
    @Autowired
    private ForumDao forumDao;
    @PostMapping("/newforum")
    public ResponseEntity<HttpStatus> addForum(@RequestBody Forum forum){
       forumDao.addForum(forum);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/forums")
    public ResponseEntity<List<Forum>> getForums(){
        return new ResponseEntity<>(forumDao.getAllForums(),HttpStatus.OK);
    }

}

