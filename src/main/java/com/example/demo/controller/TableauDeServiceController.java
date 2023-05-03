package com.example.demo.controller;

import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.TableauDeService;
import com.example.demo.entity.User;
import com.example.demo.repository.NotificationDao;
import com.example.demo.repository.TableaDeServiceDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/")
@CrossOrigin(origins = "http://localhost:4200")
public class TableauDeServiceController {
    @Autowired
    private TableaDeServiceDao TableaDeService;
   @Autowired
   private UserService ser;
    @GetMapping("/tableau/service")

    public ResponseEntity<Set<TableauDeService>> getReplies(){
        User x=ser.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ResponseEntity<>(x.getTableauDeService(), HttpStatus.OK);
    }


}
