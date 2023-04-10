package com.example.demo.controller;
;

import com.example.demo.entity.Agenda;
import com.example.demo.repository.AgendaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AgendaController {
    @Autowired
    private AgendaDao agendaDao;
    @PostMapping("/newtask")
    public ResponseEntity<HttpStatus> addAgenda(@RequestBody Agenda agenda){

        agendaDao.addtask(agenda);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/alltasks/{mat_Pers}")
    public ResponseEntity<List<Agenda>> getagenda(@PathVariable String mat_Pers){
        return new ResponseEntity<>(agendaDao.getAlltasks(mat_Pers),HttpStatus.OK) ;
    }
    @DeleteMapping(value = "/delete")
    public void deletetask (@RequestParam (value = "id") long id){
        agendaDao.DeleteTask(id);
    }
}