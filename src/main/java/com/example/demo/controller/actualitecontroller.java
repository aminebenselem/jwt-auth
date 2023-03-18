package com.example.demo.controller;

import com.example.demo.entity.Actualite;
import com.example.demo.service.actualiteservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class actualitecontroller {

@Autowired
    public final actualiteservice service;

    public actualitecontroller(actualiteservice service) {
        this.service = service;
    }
    @GetMapping("/actualite")
    public List<Actualite> getAllActualite(){
        return service.getAllActualite();
    }

}
