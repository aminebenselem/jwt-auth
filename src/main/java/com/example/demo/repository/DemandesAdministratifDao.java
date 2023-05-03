package com.example.demo.repository;

import com.example.demo.entity.DemandesAdministratif;
import com.example.demo.entity.Event;
import com.example.demo.entity.TableauDeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DemandesAdministratifDao {


    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addDemandes(DemandesAdministratif demande) {
        entityManager.createNativeQuery("INSERT INTO DemandesAdministratif (Proved, Type, Uri,Uri1,Mat_Pers) VALUES (?1,?2,?3,?4,?5)")
                .setParameter(1, demande.getProved())
                .setParameter(2, demande.getType())
                .setParameter(3, demande.getUri())
                .setParameter(4, demande.getUri1())
                .setParameter(5, SecurityContextHolder.getContext().getAuthentication().getName())
                .executeUpdate();
    }

    @Transactional
    public List<DemandesAdministratif> getDemandes (){
        TypedQuery<DemandesAdministratif> query = entityManager.createQuery("SELECT e FROM DemandesAdministratif e", DemandesAdministratif.class);
        return query.getResultList();
    }
}
