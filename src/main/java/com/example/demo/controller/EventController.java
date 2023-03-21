package com.example.demo.controller;

import com.example.demo.entity.Event;
import com.example.demo.repository.EventDao;
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
    @PostMapping("/newevent")
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Event event){
        event.getDate().setTime( event.getDate().getTime() + (1000 * 60 * 60 * 24));

        eventDao.addEvent(event);
         return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/events")
    public ResponseEntity<List<Event>> getEvents(){
        return new ResponseEntity<>(eventDao.getAllEvents(),HttpStatus.OK) ;
    }
}

