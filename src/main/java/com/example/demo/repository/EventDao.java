package com.example.demo.repository;

import com.example.demo.entity.Event;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public class EventDao {

    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addEvent(Event event) {
        entityManager.createNativeQuery("INSERT INTO Event (date, description, title) VALUES (?1,?2,?3)")
                .setParameter(1, event.getDate())
                .setParameter(2, event.getDescription())
                .setParameter(3, event.getTitle())
                .executeUpdate();
    }
    public List<Event> getAllEvents() {
        TypedQuery<Event> query = entityManager.createQuery("SELECT e FROM Event e", Event.class);
        return query.getResultList();
    }

}