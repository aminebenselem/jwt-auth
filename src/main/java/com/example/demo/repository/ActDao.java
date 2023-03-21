package com.example.demo.repository;

import com.example.demo.entity.Actualite;
import com.example.demo.entity.Event;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addAct(Actualite actualite) {
        entityManager.createNativeQuery("INSERT INTO Actualite (date, description, title,type,uri) VALUES (?1,?2,?3,?4,?5)")
                .setParameter(1, actualite.getDate())
                .setParameter(2, actualite.getDescription())
                .setParameter(3, actualite.getTitle())
                .setParameter(4,actualite.getType())
                .setParameter(5,actualite.getUri())
                .executeUpdate();
    }
    public List<Actualite> getAllActs() {
        TypedQuery<Actualite> query = entityManager.createQuery("SELECT e FROM Actualite e", Actualite.class);
        return query.getResultList();
    }

}
