package com.example.demo.controller;
import com.example.demo.entity.Reply;
import com.example.demo.repository.ReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReplyController {
    @Autowired
    private ReplyDao replyDao;
    @PostMapping("/reply")
    public ResponseEntity<HttpStatus> Reply(@RequestBody Reply reply){
        replyDao.Reply(reply);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/replies")
    public ResponseEntity<List<Reply>> getReplies(){
        return new ResponseEntity<>(replyDao.getAllReplies(),HttpStatus.OK);
    }

}
