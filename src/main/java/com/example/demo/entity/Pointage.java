package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String  COD_SOC;
    private String TYP_POINT;
    private String H_POINT;
    private String MIN_POINT;
    private String DATE_POINT;
    private String N_CARTE;
    private String NUM_POINT;
    private String TYPE;
    private String NUM_POINTEUSE;
    private String SEMAINE;
    private String TYP_REG;
    private String COD_REG;
    private String H_REG;
    private String M_REG;
    private String COD_M;
    private String DATE_J_POINT;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAT_PERS")
    private User userPoint;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCOD_SOC() {
        return COD_SOC;
    }

    public void setCOD_SOC(String COD_SOC) {
        this.COD_SOC = COD_SOC;
    }

    public String getTYP_POINT() {
        return TYP_POINT;
    }

    public void setTYP_POINT(String TYP_POINT) {
        this.TYP_POINT = TYP_POINT;
    }

    public String getH_POINT() {
        return H_POINT;
    }

    public void setH_POINT(String h_POINT) {
        H_POINT = h_POINT;
    }

    public String getMIN_POINT() {
        return MIN_POINT;
    }

    public void setMIN_POINT(String MIN_POINT) {
        this.MIN_POINT = MIN_POINT;
    }

    public String getDATE_POINT() {
        return DATE_POINT;
    }

    public void setDATE_POINT(String DATE_POINT) {
        this.DATE_POINT = DATE_POINT;
    }

    public String getN_CARTE() {
        return N_CARTE;
    }

    public void setN_CARTE(String n_CARTE) {
        N_CARTE = n_CARTE;
    }

    public String getNUM_POINT() {
        return NUM_POINT;
    }

    public void setNUM_POINT(String NUM_POINT) {
        this.NUM_POINT = NUM_POINT;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getNUM_POINTEUSE() {
        return NUM_POINTEUSE;
    }

    public void setNUM_POINTEUSE(String NUM_POINTEUSE) {
        this.NUM_POINTEUSE = NUM_POINTEUSE;
    }

    public String getSEMAINE() {
        return SEMAINE;
    }

    public void setSEMAINE(String SEMAINE) {
        this.SEMAINE = SEMAINE;
    }

    public String getTYP_REG() {
        return TYP_REG;
    }

    public void setTYP_REG(String TYP_REG) {
        this.TYP_REG = TYP_REG;
    }

    public String getCOD_REG() {
        return COD_REG;
    }

    public void setCOD_REG(String COD_REG) {
        this.COD_REG = COD_REG;
    }

    public String getH_REG() {
        return H_REG;
    }

    public void setH_REG(String h_REG) {
        H_REG = h_REG;
    }

    public String getM_REG() {
        return M_REG;
    }

    public void setM_REG(String m_REG) {
        M_REG = m_REG;
    }

    public String getCOD_M() {
        return COD_M;
    }

    public void setCOD_M(String COD_M) {
        this.COD_M = COD_M;
    }

    public String getDATE_J_POINT() {
        return DATE_J_POINT;
    }

    public void setDATE_J_POINT(String DATE_J_POINT) {
        this.DATE_J_POINT = DATE_J_POINT;
    }

    public User getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(User userPoint) {
        this.userPoint = userPoint;
    }



}
