package com.example.demo.repository;

import com.example.demo.entity.DemandesAdministratif;
import com.example.demo.entity.DocumentsUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentsUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addDoc(DocumentsUser doc) {
        entityManager.createNativeQuery("INSERT INTO DocumentUser (Uri,name,Mat_Pers) VALUES (?1,?2,?3)")
                .setParameter(1, doc.getUri())
                .setParameter(2, doc.getName())

                .setParameter(3, SecurityContextHolder.getContext().getAuthentication().getName())
                .executeUpdate();
    }
    @Transactional
    public List<DocumentsUser> getDoc (String mat_pers){
        TypedQuery<DocumentsUser> query = entityManager.createQuery("SELECT e FROM DocumentsUser e WHERE e.Mat_Pers=?1", DocumentsUser.class);
        return query.getResultList();
    }
}
