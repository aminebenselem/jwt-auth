package com.example.demo.repository;

import com.example.demo.entity.Forum;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForumDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addForum(Forum forum) {
        entityManager.createNativeQuery("INSERT INTO Forum (title,body,Mat_Pers) VALUES (?1,?2,?3)")
                .setParameter(1, forum.getTitle())
                .setParameter(2, forum.getBody())
                .setParameter(3, forum.getUser().getMat_Pers())
                .executeUpdate();
    }
    public List<Forum> getAllForums() {
        TypedQuery<Forum> query = entityManager.createQuery("SELECT e FROM Forum e", Forum.class);
        return query.getResultList();
    }
    public Forum getById(@Param("id") long id) {
        TypedQuery<Forum> query = entityManager.createQuery("SELECT e FROM Forum e where e.id=?1", Forum.class)
                .setParameter(1,id);
        return query.getSingleResult();
    }
    
}