package com.example.demo.controller;

import com.example.demo.entity.DocumentsUser;
import com.example.demo.entity.User;
import com.example.demo.repository.DocumentsUserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentsUserController {
    @Autowired
    private final DocumentsUserDao service;
    @Autowired
    private UserService ser;

    public DocumentsUserController(DocumentsUserDao service, UserService ser) {
        this.service = service;
        this.ser = ser;
    }

    @PostMapping("/newdoc")
    public ResponseEntity<HttpStatus> addDoc(@RequestBody DocumentsUser demande){

        service.addDoc(demande);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getdoc")
    public ResponseEntity<Set<DocumentsUser>> getDoc(){
        User x=ser.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(x.getDoc(), HttpStatus.OK);
    }
}
