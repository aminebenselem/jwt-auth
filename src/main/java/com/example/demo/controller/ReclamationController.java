package com.example.demo.controller;

import com.example.demo.entity.Reclamation;
import com.example.demo.repository.ReclamationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationController {

    @Autowired
    private ReclamationDao reclamationDao;
    @PostMapping("/newrec")
    public ResponseEntity<HttpStatus> addReclamation(@RequestBody Reclamation reclamation){
        reclamationDao.addreclamtion(reclamation);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/reclamation")
    public ResponseEntity<List<Reclamation>> getReclamation(){
        return new ResponseEntity<>(reclamationDao.getAllReclamation(),HttpStatus.OK) ;
    }
}

