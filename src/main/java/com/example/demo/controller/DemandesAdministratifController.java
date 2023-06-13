package com.example.demo.controller;

import com.example.demo.entity.DemandesAdministratif;
import com.example.demo.repository.DemandesAdministratifDao;
import com.example.demo.repository.DemandesDao;
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
    @Autowired
    private final DemandesDao ser;

    public DemandesAdministratifController(DemandesAdministratifDao service, DemandesDao ser) {
        this.service = service;
        this.ser = ser;
    }


    @PostMapping("/newdemande")
    public ResponseEntity<HttpStatus> adddemande(@RequestBody DemandesAdministratif demande){

       service.addDemandes(demande);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getdemandes")
    public ResponseEntity<List<DemandesAdministratif>> getDemandes(){
        return new ResponseEntity<>(service.getDemandes(),HttpStatus.OK) ;
    }

@PutMapping ("/update")
    public void updateProved(@RequestBody DemandesAdministratif demanded){
    DemandesAdministratif x = new DemandesAdministratif();
    x.setId(demanded.getId());
    x.setProved(demanded.getProved());

    ser.updatefich(x.getProved(),x.getId());
}


}
