package com.example.demo.repository;

import com.example.demo.entity.Notification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void addNotification(Notification notification) {
        entityManager.createNativeQuery("INSERT INTO Notification (message,Mat_Pers,viewed) VALUES (?1,?2,?3)")
                .setParameter(1, notification.getMessage())
                .setParameter(2,notification.getUser().getMat_Pers())
                .setParameter(3,false)
                .executeUpdate();
    }
    public List<Notification> getAllNotif() {
        TypedQuery<Notification> query = entityManager.createQuery("SELECT e FROM Notification e", Notification.class);
        return query.getResultList();
    }
}
