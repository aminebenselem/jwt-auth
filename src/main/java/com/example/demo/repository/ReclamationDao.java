package com.example.demo.repository;

import com.example.demo.entity.Reclamation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReclamationDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addreclamtion(Reclamation reclamation) {
        entityManager.createNativeQuery("INSERT INTO Reclamation (id,email,subject,message,departement,Mat_Pers) VALUES (?1,?2,?3,?4,?5,?6)")
                .setParameter(1, reclamation.getId())
                .setParameter(2, reclamation.getEmail())
                .setParameter(3, reclamation.getSubject())
                .setParameter(4,reclamation.getMessage())
                .setParameter(5,reclamation.getDepartement())
                .setParameter(6,reclamation.getUser().getMat_Pers())
                .executeUpdate();
    }
    public List<Reclamation> getAllReclamation() {
        TypedQuery<Reclamation> query = entityManager.createQuery("SELECT e FROM Reclamation e", Reclamation.class);
        return query.getResultList();
    }
}
