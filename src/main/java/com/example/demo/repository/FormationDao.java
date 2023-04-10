//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.repository;

import com.example.demo.entity.Formation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class FormationDao {
    @PersistenceContext
    EntityManager entityManager;

    public FormationDao() {
    }

    @Transactional
    public void addFormation(Formation formation) {
        this.entityManager.createNativeQuery("INSERT INTO Formation (categorie,theme,datedb,datefn,formateur,cabinet) VALUES (?1,?2,?3,?4,?5,?6)").setParameter(1, formation.getCategorie()).setParameter(2, formation.getTheme()).setParameter(3, formation.getDatedb()).setParameter(4, formation.getDatefn()).setParameter(5, formation.getFormateur()).setParameter(6, formation.getCabinet()).executeUpdate();
    }
}
