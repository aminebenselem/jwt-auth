package com.example.demo.repository;

import com.example.demo.entity.Reply;
import com.example.demo.entity.ReplyRec;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReplyRecDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void Reply(ReplyRec reply) {
        entityManager.createNativeQuery("INSERT INTO ReplyRec (rec_id,body,Mat_Pers) VALUES (?1,?2,?3)")
                .setParameter(1, reply.getReclamation().getId())
                .setParameter(2, reply.getBody())
                .setParameter(3, reply.getUser().getMat_Pers())
                .executeUpdate();
    }
    public List<ReplyRec> getAllReplies() {
        TypedQuery<ReplyRec> query = entityManager.createQuery("SELECT e FROM ReplyRec e", ReplyRec.class);
        return query.getResultList();
    }


}
