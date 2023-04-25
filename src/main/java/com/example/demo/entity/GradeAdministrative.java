package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "grade_administratif")
public class GradeAdministrative {
    public User getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(User userGrade) {
        this.userGrade = userGrade;
    }

    public String getLIB_ADM() {
        return LIB_ADM;
    }

    public void setLIB_ADM(String LIB_ADM) {
        this.LIB_ADM = LIB_ADM;
    }

    public String getLIB_ADM_A() {
        return LIB_ADM_A;
    }

    public void setLIB_ADM_A(String LIB_ADM_A) {
        this.LIB_ADM_A = LIB_ADM_A;
    }

    public String getTYPE_GRADE() {
        return TYPE_GRADE;
    }

    public void setTYPE_GRADE(String TYPE_GRADE) {
        this.TYPE_GRADE = TYPE_GRADE;
    }

    public String getTYPE_GRADE_A() {
        return TYPE_GRADE_A;
    }

    public void setTYPE_GRADE_A(String TYPE_GRADE_A) {
        this.TYPE_GRADE_A = TYPE_GRADE_A;
    }

    public String getABRV_GRD() {
        return ABRV_GRD;
    }

    public void setABRV_GRD(String ABRV_GRD) {
        this.ABRV_GRD = ABRV_GRD;
    }

    public String getADM_TECH() {
        return ADM_TECH;
    }

    public void setADM_TECH(String ADM_TECH) {
        this.ADM_TECH = ADM_TECH;
    }

    public String getDUREE() {
        return DUREE;
    }

    public void setDUREE(String DUREE) {
        this.DUREE = DUREE;
    }

    public String getDUREE_AUT() {
        return DUREE_AUT;
    }

    public void setDUREE_AUT(String DUREE_AUT) {
        this.DUREE_AUT = DUREE_AUT;
    }

    public String getUNIFORM() {
        return UNIFORM;
    }

    public void setUNIFORM(String UNIFORM) {
        this.UNIFORM = UNIFORM;
    }

    public String getCOEF_REND() {
        return COEF_REND;
    }

    public void setCOEF_REND(String COEF_REND) {
        this.COEF_REND = COEF_REND;
    }
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
 @JoinColumn(name = "GRADE_ADM", referencedColumnName = "GRADE_ADM")
 private User userGrade;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String LIB_ADM;
    private String LIB_ADM_A;
    private String TYPE_GRADE;
    private String TYPE_GRADE_A;
    private String ABRV_GRD;
    private  String ADM_TECH;
    private  String DUREE;
    private  String DUREE_AUT;
    private  String UNIFORM;
    private  String COEF_REND;
}
