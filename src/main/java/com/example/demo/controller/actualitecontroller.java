package com.example.demo.controller;

import com.example.demo.entity.Actualite;
import com.example.demo.repository.ActDao;
import com.example.demo.service.actualiteservice;
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
    private actualiteservice service;
    @Autowired
    private ActDao actDao;

    @GetMapping("/actualite")
    public List<Actualite> getAllActualite(){
        return service.getAllActualite();
    }
    @PostMapping("/newact")
    public ResponseEntity<HttpStatus> addAct(@RequestBody Actualite actualite){
        actualite.getDate().setTime( actualite.getDate().getTime() + (1000 * 60 * 60 * 24));
         actDao.addAct(actualite);
         return new ResponseEntity<>(HttpStatus.OK);
    }

}
