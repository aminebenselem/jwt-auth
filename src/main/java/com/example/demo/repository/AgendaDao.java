package com.example.demo.repository;



import com.example.demo.entity.Agenda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AgendaDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addtask(Agenda agenda) {
        entityManager.createNativeQuery("INSERT INTO Agenda (Date,Task,Mat_Pers) VALUES (?1,?2,?3)")
                .setParameter(1, agenda.getDate())
                .setParameter(2, agenda.getTask())
                .setParameter(3,agenda.getUser().getMat_Pers())
                .executeUpdate();
    }

    public List<Agenda> getAlltasks(String mat_Pers) {
        TypedQuery<Agenda> query = entityManager.createQuery("SELECT e FROM Agenda e where e.personnel.Mat_Pers=?1", Agenda.class);
        return query.getResultList();
    }
    @Transactional
    public  void DeleteTask(long id) {

       entityManager.createNativeQuery("DELETE  FROM Agenda  WHERE id= ?1").setParameter(1, id)
      .executeUpdate();

    }
}