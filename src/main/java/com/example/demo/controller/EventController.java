package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventDao;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    @Autowired
    private EventDao eventDao;
    @Autowired
    private EmailService emailService;
    @PostMapping("/newevent")
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Event event){
        event.getDate().setTime( event.getDate().getTime() + (1000 * 60 * 60 * 24));
        emailService.sendSimpleMessage("abensaid511@gmail.com", "Nouveau Evénement", "Bonjour vous avez un nouveau événement","http://localhost:4200/events");
        eventDao.addEvent(event);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents(){
        return new ResponseEntity<>(eventDao.getAllEvents(),HttpStatus.OK) ;
    }
}

