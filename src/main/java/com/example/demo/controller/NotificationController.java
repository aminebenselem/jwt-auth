package com.example.demo.controller;

import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {
    @Autowired
    private NotificationDao notificationDao;

    public NotificationController(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @PostMapping("/notify")
    public ResponseEntity<HttpStatus> Reply(@RequestBody Notification notification){
        notificationDao.addNotification(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/notification")
    public ResponseEntity<List<Notification>> getReplies(){
        return new ResponseEntity<>(notificationDao.getAllNotif(),HttpStatus.OK);
    }
}
