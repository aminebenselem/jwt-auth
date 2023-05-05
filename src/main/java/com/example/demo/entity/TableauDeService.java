package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name="tableau_service")
public class TableauDeService {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String  COD_SOC;

private int YEARS ;
private int MONTHS ;
private int  DAYS;
private int J_SEMAINE;
private String COD_M;
private int SEMAINE;
private String PREC_COD_M ;
private int BASE_H ;
private int BASE_M;
 private  String PAUSE_SHIFT;
 private String MARG_SHIFT;
  private String  COD_REG;
  private String COD_DEPT;
  private String COD_SERV ;
  private String PRES_H;
  private String PRES_M;
  private String UNIT_CAL;
  private String REG_BASE;
  private String EQUIP_BASE ;

    public String getPRES_M() {
        return PRES_M;
    }

    public void setPRES_M(String PRES_M) {
        this.PRES_M = PRES_M;
    }

    public String getCOD_SOC() {
        return COD_SOC;
    }

    public void setCOD_SOC(String COD_SOC) {
        this.COD_SOC = COD_SOC;
    }

    public int getYEARS() {
        return YEARS;
    }

    public void setYEARS(int YEARS) {
        this.YEARS = YEARS;
    }

    public int getMONTHS() {
        return MONTHS;
    }

    public void setMONTHS(int MONTHS) {
        this.MONTHS = MONTHS;
    }

    public int getDAYS() {
        return DAYS;
    }

    public void setDAYS(int DAYS) {
        this.DAYS = DAYS;
    }

    public int getJ_SEMAINE() {
        return J_SEMAINE;
    }

    public void setJ_SEMAINE(int j_SEMAINE) {
        J_SEMAINE = j_SEMAINE;
    }

    public String getCOD_M() {
        return COD_M;
    }

    public void setCOD_M(String COD_M) {
        this.COD_M = COD_M;
    }

    public int getSEMAINE() {
        return SEMAINE;
    }

    public void setSEMAINE(int SEMAINE) {
        this.SEMAINE = SEMAINE;
    }

    public String getPREC_COD_M() {
        return PREC_COD_M;
    }

    public void setPREC_COD_M(String PREC_COD_M) {
        this.PREC_COD_M = PREC_COD_M;
    }

    public int getBASE_H() {
        return BASE_H;
    }

    public void setBASE_H(int BASE_H) {
        this.BASE_H = BASE_H;
    }

    public int getBASE_M() {
        return BASE_M;
    }

    public void setBASE_M(int BASE_M) {
        this.BASE_M = BASE_M;
    }

    public String getPAUSE_SHIFT() {
        return PAUSE_SHIFT;
    }

    public void setPAUSE_SHIFT(String PAUSE_SHIFT) {
        this.PAUSE_SHIFT = PAUSE_SHIFT;
    }

    public String getMARG_SHIFT() {
        return MARG_SHIFT;
    }

    public void setMARG_SHIFT(String MARG_SHIFT) {
        this.MARG_SHIFT = MARG_SHIFT;
    }

    public String getCOD_REG() {
        return COD_REG;
    }

    public void setCOD_REG(String COD_REG) {
        this.COD_REG = COD_REG;
    }

    public String getCOD_DEPT() {
        return COD_DEPT;
    }

    public void setCOD_DEPT(String COD_DEPT) {
        this.COD_DEPT = COD_DEPT;
    }

    public String getCOD_SERV() {
        return COD_SERV;
    }

    public void setCOD_SERV(String COD_SERV) {
        this.COD_SERV = COD_SERV;
    }

    public String getPRES_H() {
        return PRES_H;
    }

    public void setPRES_H(String PRES_H) {
        this.PRES_H = PRES_H;
    }



    public String getUNIT_CAL() {
        return UNIT_CAL;
    }

    public void setUNIT_CAL(String UNIT_CAL) {
        this.UNIT_CAL = UNIT_CAL;
    }

    public String getREG_BASE() {
        return REG_BASE;
    }

    public void setREG_BASE(String REG_BASE) {
        this.REG_BASE = REG_BASE;
    }

    public String getEQUIP_BASE() {
        return EQUIP_BASE;
    }

    public void setEQUIP_BASE(String EQUIP_BASE) {
        this.EQUIP_BASE = EQUIP_BASE;
    }

    public User getUserT() {
        return userT;
    }

    public void setUserT(User userT) {
        this.userT = userT;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mat_Pers")
    private User userT;

}
