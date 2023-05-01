package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Famille {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private int NUM_FAM;
    private String PARENTE_ACT;
    private String Nom_JF;
    private String COD_ACTIVITE;
    private String PRENOM;
    private String PARENTE;
    private String DAT_MAR;
    private String DAT_NAISS;
    private String SEXE;
    private String BENEF;
    private String REGIME_CONJ;
    private String DAT_DECE;
    private String MAT_CONJ;
    private String PLAF_TOT_REMB;
    private String COD_SOC;
    private String LIEU_NAISS;
    private String ASS_CONJ;
    private String PROFESSION;
    private String EMPLOYEUR;

    public String getDAT_DIV() {
        return DAT_DIV;
    }

    public void setDAT_DIV(String DAT_DIV) {
        this.DAT_DIV = DAT_DIV;
    }

    private String DAT_DIV;
    private String COD_SIT;
    private String DAT_EFFET_ACT;
    private String NUM_ASS_CONJ;
    private String DAT_ENGAG_PARENT;
    private String DAT_E_SAIS;
    private String DATE_VALIDATION;
    private String DECLAR_ALL;
    private String PROCED_JUDIC;
    private String PENSION;
    private String ETAT_FAM;
    private String GRP_SANG;
    private String T_PAIE;
    private String ETAT_SANTE;
    private String BOURSIER;
    private String ROWID;

    public int getNUM_FAM() {
        return NUM_FAM;
    }

    public void setNUM_FAM(int NUM_FAM) {
        this.NUM_FAM = NUM_FAM;
    }

    public String getPARENTE_ACT() {
        return PARENTE_ACT;
    }

    public void setPARENTE_ACT(String PARENTE_ACT) {
        this.PARENTE_ACT = PARENTE_ACT;
    }

    public String getCOD_ACTIVITE() {
        return COD_ACTIVITE;
    }

    public void setCOD_ACTIVITE(String COD_ACTIVITE) {
        this.COD_ACTIVITE = COD_ACTIVITE;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getPARENTE() {
        return PARENTE;
    }

    public void setPARENTE(String PARENTE) {
        this.PARENTE = PARENTE;
    }

    public String getDAT_MAR() {
        return DAT_MAR;
    }

    public void setDAT_MAR(String DAT_MAR) {
        this.DAT_MAR = DAT_MAR;
    }

    public String getDAT_NAISS() {
        return DAT_NAISS;
    }

    public void setDAT_NAISS(String DAT_NAISS) {
        this.DAT_NAISS = DAT_NAISS;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) {
        this.SEXE = SEXE;
    }

    public String getBENEF() {
        return BENEF;
    }

    public void setBENEF(String BENEF) {
        this.BENEF = BENEF;
    }

    public String getREGIME_CONJ() {
        return REGIME_CONJ;
    }

    public void setREGIME_CONJ(String REGIME_CONJ) {
        this.REGIME_CONJ = REGIME_CONJ;
    }

    public String getDAT_DECE() {
        return DAT_DECE;
    }

    public void setDAT_DECE(String DAT_DECE) {
        this.DAT_DECE = DAT_DECE;
    }

    public String getMAT_CONJ() {
        return MAT_CONJ;
    }

    public void setMAT_CONJ(String MAT_CONJ) {
        this.MAT_CONJ = MAT_CONJ;
    }

    public String getPLAF_TOT_REMB() {
        return PLAF_TOT_REMB;
    }

    public void setPLAF_TOT_REMB(String PLAF_TOT_REMB) {
        this.PLAF_TOT_REMB = PLAF_TOT_REMB;
    }

    public String getCOD_SOC() {
        return COD_SOC;
    }

    public void setCOD_SOC(String COD_SOC) {
        this.COD_SOC = COD_SOC;
    }
    public String getNom_JF() {
        return Nom_JF;
    }

    public void setNom_JF(String nom_JF) {
        Nom_JF = nom_JF;
    }
    public String getLIEU_NAISS() {
        return LIEU_NAISS;
    }

    public void setLIEU_NAISS(String LIEU_NAISS) {
        this.LIEU_NAISS = LIEU_NAISS;
    }

    public String getASS_CONJ() {
        return ASS_CONJ;
    }

    public void setASS_CONJ(String ASS_CONJ) {
        this.ASS_CONJ = ASS_CONJ;
    }

    public String getPROFESSION() {
        return PROFESSION;
    }

    public void setPROFESSION(String PROFESSION) {
        this.PROFESSION = PROFESSION;
    }

    public String getEMPLOYEUR() {
        return EMPLOYEUR;
    }

    public void setEMPLOYEUR(String EMPLOYEUR) {
        this.EMPLOYEUR = EMPLOYEUR;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }

    public String getDAT_EFFET_ACT() {
        return DAT_EFFET_ACT;
    }

    public void setDAT_EFFET_ACT(String DAT_EFFET_ACT) {
        this.DAT_EFFET_ACT = DAT_EFFET_ACT;
    }

    public String getNUM_ASS_CONJ() {
        return NUM_ASS_CONJ;
    }

    public void setNUM_ASS_CONJ(String NUM_ASS_CONJ) {
        this.NUM_ASS_CONJ = NUM_ASS_CONJ;
    }

    public String getDAT_ENGAG_PARENT() {
        return DAT_ENGAG_PARENT;
    }

    public void setDAT_ENGAG_PARENT(String DAT_ENGAG_PARENT) {
        this.DAT_ENGAG_PARENT = DAT_ENGAG_PARENT;
    }

    public String getDAT_E_SAIS() {
        return DAT_E_SAIS;
    }

    public void setDAT_E_SAIS(String DAT_E_SAIS) {
        this.DAT_E_SAIS = DAT_E_SAIS;
    }

    public String getDATE_VALIDATION() {
        return DATE_VALIDATION;
    }

    public void setDATE_VALIDATION(String DATE_VALIDATION) {
        this.DATE_VALIDATION = DATE_VALIDATION;
    }

    public String getDECLAR_ALL() {
        return DECLAR_ALL;
    }

    public void setDECLAR_ALL(String DECLAR_ALL) {
        this.DECLAR_ALL = DECLAR_ALL;
    }

    public String getPROCED_JUDIC() {
        return PROCED_JUDIC;
    }

    public void setPROCED_JUDIC(String PROCED_JUDIC) {
        this.PROCED_JUDIC = PROCED_JUDIC;
    }

    public String getPENSION() {
        return PENSION;
    }

    public void setPENSION(String PENSION) {
        this.PENSION = PENSION;
    }

    public String getETAT_FAM() {
        return ETAT_FAM;
    }

    public void setETAT_FAM(String ETAT_FAM) {
        this.ETAT_FAM = ETAT_FAM;
    }

    public String getGRP_SANG() {
        return GRP_SANG;
    }

    public void setGRP_SANG(String GRP_SANG) {
        this.GRP_SANG = GRP_SANG;
    }

    public String getT_PAIE() {
        return T_PAIE;
    }

    public void setT_PAIE(String t_PAIE) {
        T_PAIE = t_PAIE;
    }

    public String getETAT_SANTE() {
        return ETAT_SANTE;
    }

    public void setETAT_SANTE(String ETAT_SANTE) {
        this.ETAT_SANTE = ETAT_SANTE;
    }

    public String getBOURSIER() {
        return BOURSIER;
    }

    public void setBOURSIER(String BOURSIER) {
        this.BOURSIER = BOURSIER;
    }

    public String getROWID() {
        return ROWID;
    }

    public void setROWID(String ROWID) {
        this.ROWID = ROWID;
    }

    public User getUserFamily() {
        return userFamily;
    }

    public void setUserFamily(User userFamily) {
        this.userFamily = userFamily;
    }
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mat_Pers")
    private User userFamily;

}
