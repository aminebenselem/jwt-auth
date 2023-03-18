package com.example.demo.service;

import com.example.demo.entity.Actualite;
import com.example.demo.repository.actualiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class actualiteservice {
    @Autowired
    private final actualiteDao repo;

    public actualiteservice(actualiteDao repo) {
        this.repo = repo;
    }
    public List<Actualite> getAllActualite(){
        return repo.findAll();
    }

}
