//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.repository;

import com.example.demo.entity.Formation;
import com.example.demo.entity.Reclamation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FormationDao {
    @PersistenceContext
    EntityManager entityManager;

    public FormationDao() {
    }

    @Transactional
    public void addFormation(Formation formation) {
        this.entityManager.createNativeQuery("INSERT INTO Formation (categorie,theme,datedb,datefn,formateur,cabinet,uri) VALUES (?1,?2,?3,?4,?5,?6,?7)").setParameter(1, formation.getCategorie()).setParameter(2, formation.getTheme()).setParameter(3, formation.getDatedb()).setParameter(4, formation.getDatefn()).setParameter(5, formation.getFormateur()).setParameter(6, formation.getCabinet()).setParameter(7, formation.getUri()).executeUpdate();
    }
    @Transactional
    public List<Formation> getAllForamtion() {
        TypedQuery<Formation> query = entityManager.createQuery("SELECT e FROM Formation e", Formation.class);
        return query.getResultList();
    }
}
