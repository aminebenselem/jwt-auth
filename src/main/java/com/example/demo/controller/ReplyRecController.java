package com.example.demo.controller;
import com.example.demo.entity.Reply;
import com.example.demo.entity.ReplyRec;
import com.example.demo.repository.ReplyDao;
import com.example.demo.repository.ReplyRecDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReplyRecController {
    @Autowired
    private ReplyRecDao replyDao;
    @PostMapping("/replyRec")
    public ResponseEntity<HttpStatus> Reply(@RequestBody ReplyRec reply){
        replyDao.Reply(reply);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/recReplies")
    public ResponseEntity<List<ReplyRec>> getReplies(){
        return new ResponseEntity<>(replyDao.getAllReplies(),HttpStatus.OK);
    }

}
