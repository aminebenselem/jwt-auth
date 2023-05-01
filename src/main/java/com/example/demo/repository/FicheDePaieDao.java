package com.example.demo.repository;

import com.example.demo.entity.FicheDePaie;
import com.example.demo.entity.Formation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FicheDePaieDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addFicheDePaie(FicheDePaie fiche) {
        entityManager.createNativeQuery("INSERT INTO FicheDePaie (Date,Mat_Pers) VALUES (?1,?2)")
                .setParameter(1, fiche.getDate())
                .setParameter(2, fiche.getUser().getMat_Pers())
                .executeUpdate();
    }
    @Transactional
    public List<FicheDePaie> getAllFicheDePaie() {
        TypedQuery<FicheDePaie> query = entityManager.createQuery("SELECT e FROM FicheDePaie e", FicheDePaie.class);
        return query.getResultList();
    }
    @Transactional
    public FicheDePaie getfiche( long id) {
        TypedQuery<FicheDePaie> query = entityManager.createQuery("SELECT e FROM FicheDePaie e where e.id=?1 ", FicheDePaie.class)
                .setParameter(1,id);
        return query.getSingleResult();
    }
    @Transactional
    @Modifying
    public void updateFicheDePaie(FicheDePaie fiche) {
         long x=fiche.getId();
        entityManager.createNativeQuery("UPDATE FicheDePaie e SET e.uri=?1 WHERE  e.Id= ?2 ", FicheDePaie.class)
                .setParameter(1, fiche.getUri())
                .setParameter(2, x)
                .executeUpdate();
    }

}