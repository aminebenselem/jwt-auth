package com.example.demo.repository;

import com.example.demo.entity.Forum;
import com.example.demo.entity.Reclamation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReclamationDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addreclamtion(Reclamation reclamation) {
        entityManager.createNativeQuery("INSERT INTO Reclamation (email,subject,message,departement,Mat_Pers,replycount) VALUES (?1,?2,?3,?4,?5,?6)")
                .setParameter(1, reclamation.getEmail())
                .setParameter(2, reclamation.getSubject())
                .setParameter(3,reclamation.getMessage())
                .setParameter(4,reclamation.getDepartement())
                .setParameter(5,reclamation.getUser().getMat_Pers())
                .setParameter(6,0)
                .executeUpdate();
    }
    public List<Reclamation> getAllReclamation() {
        TypedQuery<Reclamation> query = entityManager.createQuery("SELECT e FROM Reclamation e", Reclamation.class);
        return query.getResultList();
    }
    public Reclamation getById(@Param("id") long id) {
        TypedQuery<Reclamation> query = entityManager.createQuery("SELECT e FROM Reclamation e where e.id=?1", Reclamation.class)
                .setParameter(1,id);
        return query.getSingleResult();
    }
}
