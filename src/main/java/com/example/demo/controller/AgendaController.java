//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.controller;

import com.example.demo.entity.Agenda;
import com.example.demo.repository.AgendaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"http://localhost:4200"}
)
public class AgendaController {
    @Autowired
    private AgendaDao agendaDao;

    public AgendaController() {
    }

    @PostMapping({"/newtask"})
    public ResponseEntity<HttpStatus> addAgenda(@RequestBody Agenda agenda) {
        this.agendaDao.addtask(agenda);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping({"/alltasks"})
    public ResponseEntity<List<Agenda>> getagenda() {
        return new ResponseEntity<>(this.agendaDao.getAlltasks(SecurityContextHolder.getContext().getAuthentication().getName()), HttpStatus.OK);
    }

    @DeleteMapping({"/delete"})
    public void deletetask(@RequestParam("id") long id) {
        this.agendaDao.DeleteTask(id);
    }
}
