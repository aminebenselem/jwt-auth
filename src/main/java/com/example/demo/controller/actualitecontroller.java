package com.example.demo.controller;

import com.example.demo.entity.Actualite;
import com.example.demo.repository.ActDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class actualitecontroller {

    @Autowired
    private ActDao eventDao;
    @PostMapping("/newact")
    public ResponseEntity<HttpStatus> addEvent(@RequestBody Actualite event){
        event.getDate().setTime( event.getDate().getTime() + (1000 * 60 * 60 * 24));

        eventDao.addAct(event);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/actualite")
    public ResponseEntity<List<Actualite>> getAct(){
        return new ResponseEntity<>(eventDao.getAllActs(),HttpStatus.OK) ;
    }

}
