package com.example.demo.repository;

import com.example.demo.entity.Notification;
import com.example.demo.entity.TableauDeService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TableaDeServiceDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<TableauDeService> getAllNotif(String mat_pers) {
        TypedQuery<TableauDeService> query = entityManager.createQuery("SELECT e FROM TableauDeService e WHERE e.mat_Pers=?1", TableauDeService.class)
                ;
        return query.getResultList();
    }
}
