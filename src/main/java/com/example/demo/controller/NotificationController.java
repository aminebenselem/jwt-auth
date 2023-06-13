package com.example.demo.controller;

import com.example.demo.entity.Notification;
import com.example.demo.repository.NotificationDao;
import com.example.demo.repository.NotificationUpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {
    @Autowired
    private NotificationDao notificationDao;
    @Autowired
    private NotificationUpdateDao notif;

    public NotificationController(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @PostMapping("/notify")
    public ResponseEntity<HttpStatus> addNotif(@RequestBody Notification notification){
        notificationDao.addNotification(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/notification")
    public ResponseEntity<List<Notification>> getNotif(){
        return new ResponseEntity<>(notificationDao.getAllNotif(),HttpStatus.OK);
    }


    @PutMapping("/updateviewed")
    public void UpdateNotifications (@RequestBody Notification e){

        e.setViewed(true);
        notif.save(e);

    }
}
