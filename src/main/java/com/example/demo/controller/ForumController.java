package com.example.demo.controller;

import auth.ForumReply;
import com.example.demo.entity.Forum;
import com.example.demo.entity.Reply;
import com.example.demo.repository.ForumDao;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ForumController {
    @Autowired
    private ForumDao forumDao;
    @Autowired
    private EmailService emailService;
    @PostMapping("/newforum")
    public ResponseEntity<HttpStatus> addForum(@RequestBody Forum forum) {
        forumDao.addForum(forum);
        emailService.sendSimpleMessage("abensaid511@gmail.com", "Nouveau discussion", "Bonjour il ya un nouveau discussion","http://localhost:4200/forum");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/forums")
    public ResponseEntity<List<Forum>> getForums() {
        List<Forum> forums=forumDao.getAllForums();
        for (Forum forum:
             forums) {
            forum.setReplicount(forum.getReplies().size());
        }
        return new ResponseEntity<>(forums, HttpStatus.OK);
    }

    @GetMapping(value = "/forums/{id}")
    public Forum getByid(@PathVariable long id) {
        Forum forum=forumDao.getById(id);
        forum.setReplicount(forum.getReplies().size());
        return forum;

    }
    @GetMapping(value = "/forums/{id}/replies")
    public List<Reply> getForumReplies(@PathVariable long id){
        return forumDao.getById(id).getReplies();

    }
}

