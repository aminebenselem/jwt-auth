package com.example.demo.repository;

import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FicheDao extends CrudRepository<FicheDePaie, Long> {

    @Modifying
    @Transactional


    @Query("UPDATE FicheDePaie e SET e.uri=?1 WHERE  e.Id= ?2 ")
    public void updatefich(String uri, long id);
}
