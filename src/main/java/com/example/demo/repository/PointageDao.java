package com.example.demo.repository;

import com.example.demo.entity.Pointage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class PointageDao {
    @PersistenceContext
    EntityManager entityManager;
    @Transactional
    public void Pointage(Pointage pointage) {
        entityManager.createNativeQuery("INSERT INTO Pointage (COD_SOC,MAT_PERS,TYP_POINT,H_POINT,MIN_POINT,DATE_POINT,N_CARTE,NUM_POINT,TYPE,NUM_POINTEUSE,SEMAINE,TYP_REG,COD_REG,H_REG,M_REG,COD_M, DATE_J_POINT) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17)")
                .setParameter(1, pointage.getCOD_SOC())
                .setParameter(2, pointage.getUserPoint().getMat_Pers())
                .setParameter(3, pointage.getTYP_POINT())
                .setParameter(4,pointage.getH_POINT())
                .setParameter(5,pointage.getMIN_POINT())
                .setParameter(6,pointage.getDATE_POINT())
                .setParameter(7,pointage.getN_CARTE())
                .setParameter(8,pointage.getNUM_POINT())
                .setParameter(9,pointage.getTYPE())
                .setParameter(10,pointage.getNUM_POINTEUSE())
                .setParameter(11,pointage.getSEMAINE())
                .setParameter(12,pointage.getTYP_REG())
                .setParameter(13,pointage.getCOD_REG())
                .setParameter(14,pointage.getH_REG())
                .setParameter(15,pointage.getM_REG())
                .setParameter(16,pointage.getCOD_M())
                .setParameter(17,pointage.getDATE_J_POINT())
                .executeUpdate();
    }


}
