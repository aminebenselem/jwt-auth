package com.example.demo.service;

import com.example.demo.entity.Actualite;
import com.example.demo.repository.ActDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class actualiteservice {
    @Autowired
    private ActDao repo;

    public List<Actualite> getAllActualite(){return repo.getAllActs();}
    public void addAct(Actualite actualite ){
        repo.addAct(actualite);
    }

}
