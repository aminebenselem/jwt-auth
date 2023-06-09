//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.controller;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationDao;
import com.example.demo.repository.FormationRepo;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(
        origins = "http://localhost:4200"
)
public class FormationController {
    @Autowired
    private FormationDao FormationDao;
    @Autowired
    private FormationRepo Formationrepo;

    @Autowired
    private EmailService emailService;


    @PostMapping({"/addformation"})
    public ResponseEntity<HttpStatus> addFormation(@RequestBody Formation formation) {
        this.FormationDao.addFormation(formation);
        emailService.sendSimpleMessage("abensaid511@gmail.com", "Nouveau Formation", "Bonjour il ya une nouvelle formation","http://localhost:4200/formation");
        return new ResponseEntity(HttpStatus.OK);
    }
    @GetMapping("/getallformation")
    public ResponseEntity<List<Formation>> getFormation(){
        List<Formation> formations =FormationDao.getAllForamtion();


        return new ResponseEntity<>(formations,HttpStatus.OK) ;
    }

}
