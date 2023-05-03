package com.example.demo.controller;

import com.example.demo.entity.DemandesAdministratif;
import com.example.demo.entity.Event;
import com.example.demo.repository.DemandesAdministratifDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class DemandesAdministratifController {
@Autowired
private final DemandesAdministratifDao service;

    public DemandesAdministratifController(DemandesAdministratifDao service) {
        this.service = service;
    }

    @PostMapping("/newdemande")
    public ResponseEntity<HttpStatus> adddemande(@RequestBody DemandesAdministratif demande){

       service.addDemandes(demande);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getdemandes")
    public ResponseEntity<List<DemandesAdministratif>> getEvents(){
        return new ResponseEntity<>(service.getDemandes(),HttpStatus.OK) ;
    }

}
