package com.example.demo.repository;


import com.example.demo.entity.Reply;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void Reply(Reply reply) {
        entityManager.createNativeQuery("INSERT INTO Reply (forum_id,body,Mat_Pers) VALUES (?1,?2,?3)")
                .setParameter(1, reply.getForum().getId())
                .setParameter(2, reply.getBody())
                .setParameter(3, reply.getUser().getMat_Pers())
                .executeUpdate();
    }
    public List<Reply> getAllReplies() {
        TypedQuery<Reply> query = entityManager.createQuery("SELECT e FROM Reply e", Reply.class);
        return query.getResultList();
    }


}
