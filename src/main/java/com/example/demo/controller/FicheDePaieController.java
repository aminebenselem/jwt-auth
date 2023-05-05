package com.example.demo.controller;

import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.Formation;
import com.example.demo.entity.User;
import com.example.demo.repository.FicheDao;
import com.example.demo.repository.FicheDePaieDao;
import com.example.demo.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value="/fichedepaie")
@CrossOrigin(origins = "http://localhost:4200")
public class FicheDePaieController {
    @Autowired
    private FicheDePaieDao fiche;
    @Autowired
    private FicheDao Fiche;
    @Autowired
    private UserService ser;
    @PostMapping("/newfiche")
    public ResponseEntity<HttpStatus> addEvent(@RequestBody FicheDePaie ficheP){
        fiche.addFicheDePaie(ficheP);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getallfiche")
    public List<FicheDePaie> getFicheDePaie(){
        return fiche.getAllFicheDePaie() ;
    }

    @GetMapping("/getfiche/{id}")
    public FicheDePaie getFiche(@PathVariable long id){
        return fiche.getfiche(id) ;
    }
    @GetMapping("/getficheforuser")
    public Set<FicheDePaie> getFicheByUser(){
        User x=ser.getUser(SecurityContextHolder.getContext().getAuthentication().getName());


        return x.getFicheDePaie() ;
    }






    @PutMapping("/updatefiche")
    public  void UpdateFiche (@RequestBody FicheDePaie e)
{
    FicheDePaie x = new FicheDePaie();
    x.setId(e.getId());
    x.setUri(e.getUri());

      Fiche.updatefich(x.getUri(), x.getId());
}

}