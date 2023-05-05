package com.example.demo.repository;

import com.example.demo.entity.DemandesAdministratif;
import com.example.demo.entity.FicheDePaie;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandesDao extends CrudRepository<DemandesAdministratif, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE DemandesAdministratif e SET e.proved=?1 WHERE  e.id= ?2 ")
     void updatefich(String uri, long id);
}
