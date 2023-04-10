//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.controller;

import com.example.demo.entity.Formation;
import com.example.demo.repository.FormationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
public class FormationController {
    @Autowired
    private FormationDao FormationDao;

    public FormationController() {
    }

    @PostMapping({"/addformation"})
    public ResponseEntity<HttpStatus> addAgenda(@RequestBody Formation formation) {
        this.FormationDao.addFormation(formation);
        return new ResponseEntity(HttpStatus.OK);
    }
}
