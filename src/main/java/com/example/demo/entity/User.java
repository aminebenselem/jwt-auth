package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name = "personnel")

public class User implements UserDetails,GrantedAuthority {

    private String email ;
    private String numerodetelephone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerodetelephone() {
        return numerodetelephone;
    }

    public void setNumerodetelephone(String numerodetelephone) {
        this.numerodetelephone = numerodetelephone;
    }

    public String getMat_Pers() {
        return Mat_Pers;
    }

    public void setMat_Pers(String mat_Pers) {
        Mat_Pers = mat_Pers;
    }

    public String getMDP() {
        return MDP;
    }

    public void setMDP(String MDP) {
        this.MDP = MDP;
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

    public String getCOD_FONCT() {
        return COD_FONCT;
    }

    public void setCOD_FONCT(String COD_FONCT) {
        this.COD_FONCT = COD_FONCT;
    }

    public int getCOD_CATEG() {
        return COD_CATEG;
    }

    public void setCOD_CATEG(int COD_CATEG) {
        this.COD_CATEG = COD_CATEG;
    }

    public int getCOD_CAT() {
        return COD_CAT;
    }

    public void setCOD_CAT(int COD_CAT) {
        this.COD_CAT = COD_CAT;
    }

    public int getCOD_GRAD() {
        return COD_GRAD;
    }

    public void setCOD_GRAD(int COD_GRAD) {
        this.COD_GRAD = COD_GRAD;
    }

    public String getCOD_MOTIF() {
        return COD_MOTIF;
    }

    public void setCOD_MOTIF(String COD_MOTIF) {
        this.COD_MOTIF = COD_MOTIF;
    }

    public String getCOD_NATP() {
        return COD_NATP;
    }

    public void setCOD_NATP(String COD_NATP) {
        this.COD_NATP = COD_NATP;
    }

    public int getCOD_STAT() {
        return COD_STAT;
    }

    public void setCOD_STAT(int COD_STAT) {
        this.COD_STAT = COD_STAT;
    }

    public String getNOM_PERS() {
        return NOM_PERS;
    }

    public void setNOM_PERS(String NOM_PERS) {
        this.NOM_PERS = NOM_PERS;
    }

    public String getPREN_PERS() {
        return PREN_PERS;
    }

    public void setPREN_PERS(String PREN_PERS) {
        this.PREN_PERS = PREN_PERS;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) {
        this.SEXE = SEXE;
    }

    public String getDAT_DEPT() {
        return DAT_DEPT;
    }

    public void setDAT_DEPT(String DAT_DEPT) {
        this.DAT_DEPT = DAT_DEPT;
    }

    public String getDAT_SERV() {
        return DAT_SERV;
    }

    public void setDAT_SERV(String DAT_SERV) {
        this.DAT_SERV = DAT_SERV;
    }

    public String getDAT_FONCT() {
        return DAT_FONCT;
    }

    public void setDAT_FONCT(String DAT_FONCT) {
        this.DAT_FONCT = DAT_FONCT;
    }

    public String getDAT_QUALF() {
        return DAT_QUALF;
    }

    public void setDAT_QUALF(String DAT_QUALF) {
        this.DAT_QUALF = DAT_QUALF;
    }

    public String getDAT_CATEG() {
        return DAT_CATEG;
    }

    public void setDAT_CATEG(String DAT_CATEG) {
        this.DAT_CATEG = DAT_CATEG;
    }

    public String getDAT_CAT() {
        return DAT_CAT;
    }

    public void setDAT_CAT(String DAT_CAT) {
        this.DAT_CAT = DAT_CAT;
    }

    public String getDAT_GRAD() {
        return DAT_GRAD;
    }

    public void setDAT_GRAD(String DAT_GRAD) {
        this.DAT_GRAD = DAT_GRAD;
    }

    public String getDAT_ECH() {
        return DAT_ECH;
    }

    public void setDAT_ECH(String DAT_ECH) {
        this.DAT_ECH = DAT_ECH;
    }

    public String getDAT_EMB() {
        return DAT_EMB;
    }

    public void setDAT_EMB(String DAT_EMB) {
        this.DAT_EMB = DAT_EMB;
    }

    public String getDAT_ENT() {
        return DAT_ENT;
    }

    public void setDAT_ENT(String DAT_ENT) {
        this.DAT_ENT = DAT_ENT;
    }

    public String getDAT_TIT() {
        return DAT_TIT;
    }

    public void setDAT_TIT(String DAT_TIT) {
        this.DAT_TIT = DAT_TIT;
    }

    public String getDAT_MOTIF() {
        return DAT_MOTIF;
    }

    public void setDAT_MOTIF(String DAT_MOTIF) {
        this.DAT_MOTIF = DAT_MOTIF;
    }

    public String getDAT_NAIS() {
        return DAT_NAIS;
    }

    public void setDAT_NAIS(String DAT_NAIS) {
        this.DAT_NAIS = DAT_NAIS;
    }

    public String getCOD_GOUV() {
        return COD_GOUV;
    }

    public void setCOD_GOUV(String COD_GOUV) {
        this.COD_GOUV = COD_GOUV;
    }

    public String getCOD_DELEG() {
        return COD_DELEG;
    }

    public void setCOD_DELEG(String COD_DELEG) {
        this.COD_DELEG = COD_DELEG;
    }

    public String getCOD_POST() {
        return COD_POST;
    }

    public void setCOD_POST(String COD_POST) {
        this.COD_POST = COD_POST;
    }

    public String getCOD_RETR() {
        return COD_RETR;
    }

    public void setCOD_RETR(String COD_RETR) {
        this.COD_RETR = COD_RETR;
    }

    public String getETAT_ACT() {
        return ETAT_ACT;
    }

    public void setETAT_ACT(String ETAT_ACT) {
        this.ETAT_ACT = ETAT_ACT;
    }

    public String getPER_MAT_PERS() {
        return PER_MAT_PERS;
    }

    public void setPER_MAT_PERS(String PER_MAT_PERS) {
        this.PER_MAT_PERS = PER_MAT_PERS;
    }

    public String getQUALF() {
        return QUALF;
    }

    public void setQUALF(String QUALF) {
        this.QUALF = QUALF;
    }

    public String getCOD_SIT() {
        return COD_SIT;
    }

    public void setCOD_SIT(String COD_SIT) {
        this.COD_SIT = COD_SIT;
    }

    public String getDAT_SIT() {
        return DAT_SIT;
    }

    public void setDAT_SIT(String DAT_SIT) {
        this.DAT_SIT = DAT_SIT;
    }

    public String getCHEF_FAM() {
        return CHEF_FAM;
    }

    public void setCHEF_FAM(String CHEF_FAM) {
        this.CHEF_FAM = CHEF_FAM;
    }

    public int getNBRE_ENF() {
        return NBRE_ENF;
    }

    public void setNBRE_ENF(int NBRE_ENF) {
        this.NBRE_ENF = NBRE_ENF;
    }

    public String getCHARG_ENF() {
        return CHARG_ENF;
    }

    public void setCHARG_ENF(String CHARG_ENF) {
        this.CHARG_ENF = CHARG_ENF;
    }

    public String getCHARG_ALL() {
        return CHARG_ALL;
    }

    public void setCHARG_ALL(String CHARG_ALL) {
        this.CHARG_ALL = CHARG_ALL;
    }

    public String getFCT_FAM() {
        return FCT_FAM;
    }

    public void setFCT_FAM(String FCT_FAM) {
        this.FCT_FAM = FCT_FAM;
    }

    public int getCOD_ECH() {
        return COD_ECH;
    }

    public void setCOD_ECH(int COD_ECH) {
        this.COD_ECH = COD_ECH;
    }

    public String getCOD_AFFECT() {
        return COD_AFFECT;
    }

    public void setCOD_AFFECT(String COD_AFFECT) {
        this.COD_AFFECT = COD_AFFECT;
    }

    public int getCATEG_EMB() {
        return CATEG_EMB;
    }

    public void setCATEG_EMB(int CATEG_EMB) {
        this.CATEG_EMB = CATEG_EMB;
    }

    public int getCAT_EMB() {
        return CAT_EMB;
    }

    public void setCAT_EMB(int CAT_EMB) {
        this.CAT_EMB = CAT_EMB;
    }

    public int getGRAD_EMB() {
        return GRAD_EMB;
    }

    public void setGRAD_EMB(int GRAD_EMB) {
        this.GRAD_EMB = GRAD_EMB;
    }

    public int getECH_EMB() {
        return ECH_EMB;
    }

    public void setECH_EMB(int ECH_EMB) {
        this.ECH_EMB = ECH_EMB;
    }

    public String getCOD_NIVEAU() {
        return COD_NIVEAU;
    }

    public void setCOD_NIVEAU(String COD_NIVEAU) {
        this.COD_NIVEAU = COD_NIVEAU;
    }

    public String getDAT_RETR() {
        return DAT_RETR;
    }

    public void setDAT_RETR(String DAT_RETR) {
        this.DAT_RETR = DAT_RETR;
    }

    public String getDAT_DECE() {
        return DAT_DECE;
    }

    public void setDAT_DECE(String DAT_DECE) {
        this.DAT_DECE = DAT_DECE;
    }

    public String getCOD_REG() {
        return COD_REG;
    }

    public void setCOD_REG(String COD_REG) {
        this.COD_REG = COD_REG;
    }

    public String getREPOS_HBD() {
        return REPOS_HBD;
    }

    public void setREPOS_HBD(String REPOS_HBD) {
        this.REPOS_HBD = REPOS_HBD;
    }

    public String getSUSPENS_ASS() {
        return SUSPENS_ASS;
    }

    public void setSUSPENS_ASS(String SUSPENS_ASS) {
        this.SUSPENS_ASS = SUSPENS_ASS;
    }

    public String getDAT_DEB_SUSPENS() {
        return DAT_DEB_SUSPENS;
    }

    public void setDAT_DEB_SUSPENS(String DAT_DEB_SUSPENS) {
        this.DAT_DEB_SUSPENS = DAT_DEB_SUSPENS;
    }

    public String getDAT_FIN_SUSPENS() {
        return DAT_FIN_SUSPENS;
    }

    public void setDAT_FIN_SUSPENS(String DAT_FIN_SUSPENS) {
        this.DAT_FIN_SUSPENS = DAT_FIN_SUSPENS;
    }

    public String getMOTIF_SUSPENS() {
        return MOTIF_SUSPENS;
    }

    public void setMOTIF_SUSPENS(String MOTIF_SUSPENS) {
        this.MOTIF_SUSPENS = MOTIF_SUSPENS;
    }

    public String getFORM_PERS() {
        return FORM_PERS;
    }

    public void setFORM_PERS(String FORM_PERS) {
        this.FORM_PERS = FORM_PERS;
    }

    public String getCOMPTE_HERIT() {
        return COMPTE_HERIT;
    }

    public void setCOMPTE_HERIT(String COMPTE_HERIT) {
        this.COMPTE_HERIT = COMPTE_HERIT;
    }

    public String getBENEF() {
        return BENEF;
    }

    public void setBENEF(String BENEF) {
        this.BENEF = BENEF;
    }

    public String getNOM_JF() {
        return NOM_JF;
    }

    public void setNOM_JF(String NOM_JF) {
        this.NOM_JF = NOM_JF;
    }

    public String getDEPT_EMB() {
        return DEPT_EMB;
    }

    public void setDEPT_EMB(String DEPT_EMB) {
        this.DEPT_EMB = DEPT_EMB;
    }

    public String getCOMPTE_PROCED_JUDIC() {
        return COMPTE_PROCED_JUDIC;
    }

    public void setCOMPTE_PROCED_JUDIC(String COMPTE_PROCED_JUDIC) {
        this.COMPTE_PROCED_JUDIC = COMPTE_PROCED_JUDIC;
    }

    public String getBENEF_PROCED_JUDIC() {
        return BENEF_PROCED_JUDIC;
    }

    public void setBENEF_PROCED_JUDIC(String BENEF_PROCED_JUDIC) {
        this.BENEF_PROCED_JUDIC = BENEF_PROCED_JUDIC;
    }

    public String getCOD_BAT() {
        return COD_BAT;
    }

    public void setCOD_BAT(String COD_BAT) {
        this.COD_BAT = COD_BAT;
    }

    public String getCOD_BUR() {
        return COD_BUR;
    }

    public void setCOD_BUR(String COD_BUR) {
        this.COD_BUR = COD_BUR;
    }

    public String getNOM_PERS_A() {
        return NOM_PERS_A;
    }

    public void setNOM_PERS_A(String NOM_PERS_A) {
        this.NOM_PERS_A = NOM_PERS_A;
    }

    public String getPREN_PERS_A() {
        return PREN_PERS_A;
    }

    public void setPREN_PERS_A(String PREN_PERS_A) {
        this.PREN_PERS_A = PREN_PERS_A;
    }

    public String getCOD_FILL() {
        return COD_FILL;
    }

    public void setCOD_FILL(String COD_FILL) {
        this.COD_FILL = COD_FILL;
    }

    public String getDAT_FILL() {
        return DAT_FILL;
    }

    public void setDAT_FILL(String DAT_FILL) {
        this.DAT_FILL = DAT_FILL;
    }

    public String getPOSTE_TRAV() {
        return POSTE_TRAV;
    }

    public void setPOSTE_TRAV(String POSTE_TRAV) {
        this.POSTE_TRAV = POSTE_TRAV;
    }

    public String getGRADE_ADM() {
        return GRADE_ADM;
    }

    public void setGRADE_ADM(String GRADE_ADM) {
        this.GRADE_ADM = GRADE_ADM;
    }

    public String getCOD_METIER() {
        return COD_METIER;
    }

    public void setCOD_METIER(String COD_METIER) {
        this.COD_METIER = COD_METIER;
    }

    public String getREGIME_TRAV() {
        return REGIME_TRAV;
    }

    public void setREGIME_TRAV(String REGIME_TRAV) {
        this.REGIME_TRAV = REGIME_TRAV;
    }

    public String getCOD_USER() {
        return COD_USER;
    }

    public void setCOD_USER(String COD_USER) {
        this.COD_USER = COD_USER;
    }

    public String getDAT_EFFET() {
        return DAT_EFFET;
    }

    public void setDAT_EFFET(String DAT_EFFET) {
        this.DAT_EFFET = DAT_EFFET;
    }

    public String getTYPE_SERV() {
        return TYPE_SERV;
    }

    public void setTYPE_SERV(String TYPE_SERV) {
        this.TYPE_SERV = TYPE_SERV;
    }

    public String getREG_CNG() {
        return REG_CNG;
    }

    public void setREG_CNG(String REG_CNG) {
        this.REG_CNG = REG_CNG;
    }

    public String getADM_TECH() {
        return ADM_TECH;
    }

    public void setADM_TECH(String ADM_TECH) {
        this.ADM_TECH = ADM_TECH;
    }

    public String getDAT_STAT() {
        return DAT_STAT;
    }

    public void setDAT_STAT(String DAT_STAT) {
        this.DAT_STAT = DAT_STAT;
    }

    public String getDAT_CIN() {
        return DAT_CIN;
    }

    public void setDAT_CIN(String DAT_CIN) {
        this.DAT_CIN = DAT_CIN;
    }

    public String getLIE_EMI_CIN() {
        return LIE_EMI_CIN;
    }

    public void setLIE_EMI_CIN(String LIE_EMI_CIN) {
        this.LIE_EMI_CIN = LIE_EMI_CIN;
    }

    public String getDAT_AFFECT() {
        return DAT_AFFECT;
    }

    public void setDAT_AFFECT(String DAT_AFFECT) {
        this.DAT_AFFECT = DAT_AFFECT;
    }

    public String getLIEU_NAIS() {
        return LIEU_NAIS;
    }

    public void setLIEU_NAIS(String LIEU_NAIS) {
        this.LIEU_NAIS = LIEU_NAIS;
    }

    public String getCOD_LIEU_GEOG() {
        return COD_LIEU_GEOG;
    }

    public void setCOD_LIEU_GEOG(String COD_LIEU_GEOG) {
        this.COD_LIEU_GEOG = COD_LIEU_GEOG;
    }

    public String getDAT_LIEU_GEOG() {
        return DAT_LIEU_GEOG;
    }

    public void setDAT_LIEU_GEOG(String DAT_LIEU_GEOG) {
        this.DAT_LIEU_GEOG = DAT_LIEU_GEOG;
    }

    public String getFORM_PERS_A() {
        return FORM_PERS_A;
    }

    public void setFORM_PERS_A(String FORM_PERS_A) {
        this.FORM_PERS_A = FORM_PERS_A;
    }

    public String getAVC() {
        return AVC;
    }

    public void setAVC(String AVC) {
        this.AVC = AVC;
    }

    public String getAVQ() {
        return AVQ;
    }

    public void setAVQ(String AVQ) {
        this.AVQ = AVQ;
    }

    public String getDAT_AVC() {
        return DAT_AVC;
    }

    public void setDAT_AVC(String DAT_AVC) {
        this.DAT_AVC = DAT_AVC;
    }

    public String getDAT_AVQ() {
        return DAT_AVQ;
    }

    public void setDAT_AVQ(String DAT_AVQ) {
        this.DAT_AVQ = DAT_AVQ;
    }

    public String getFONCT() {
        return FONCT;
    }

    public void setFONCT(String FONCT) {
        this.FONCT = FONCT;
    }

    public String getAV_VOIT() {
        return AV_VOIT;
    }

    public void setAV_VOIT(String AV_VOIT) {
        this.AV_VOIT = AV_VOIT;
    }

    public String getTRS() {
        return TRS;
    }

    public void setTRS(String TRS) {
        this.TRS = TRS;
    }

    public String getDAT_TRS() {
        return DAT_TRS;
    }

    public void setDAT_TRS(String DAT_TRS) {
        this.DAT_TRS = DAT_TRS;
    }

    public String getDAT_VOIT() {
        return DAT_VOIT;
    }

    public void setDAT_VOIT(String DAT_VOIT) {
        this.DAT_VOIT = DAT_VOIT;
    }

    public String getAV_LOG() {
        return AV_LOG;
    }

    public void setAV_LOG(String AV_LOG) {
        this.AV_LOG = AV_LOG;
    }

    public String getDAT_LOG() {
        return DAT_LOG;
    }

    public void setDAT_LOG(String DAT_LOG) {
        this.DAT_LOG = DAT_LOG;
    }

    public String getDAT_FONCT_ANT() {
        return DAT_FONCT_ANT;
    }

    public void setDAT_FONCT_ANT(String DAT_FONCT_ANT) {
        this.DAT_FONCT_ANT = DAT_FONCT_ANT;
    }

    public String getCOMPTE_DOMIC() {
        return COMPTE_DOMIC;
    }

    public void setCOMPTE_DOMIC(String COMPTE_DOMIC) {
        this.COMPTE_DOMIC = COMPTE_DOMIC;
    }

    public String getNUM_ASS() {
        return NUM_ASS;
    }

    public void setNUM_ASS(String NUM_ASS) {
        this.NUM_ASS = NUM_ASS;
    }

    public String getGRP_SANG() {
        return GRP_SANG;
    }

    public void setGRP_SANG(String GRP_SANG) {
        this.GRP_SANG = GRP_SANG;
    }

    public String getPOINTE() {
        return POINTE;
    }

    public void setPOINTE(String POINTE) {
        this.POINTE = POINTE;
    }

    public int getTYP_CATEG() {
        return TYP_CATEG;
    }

    public void setTYP_CATEG(int TYP_CATEG) {
        this.TYP_CATEG = TYP_CATEG;
    }

    public String getSERV_MILIT() {
        return SERV_MILIT;
    }

    public void setSERV_MILIT(String SERV_MILIT) {
        this.SERV_MILIT = SERV_MILIT;
    }

    public String getNUM_RETR() {
        return NUM_RETR;
    }

    public void setNUM_RETR(String NUM_RETR) {
        this.NUM_RETR = NUM_RETR;
    }

    public String getCOD_FOND() {
        return COD_FOND;
    }

    public void setCOD_FOND(String COD_FOND) {
        this.COD_FOND = COD_FOND;
    }

    public String getNUM_FOND() {
        return NUM_FOND;
    }

    public void setNUM_FOND(String NUM_FOND) {
        this.NUM_FOND = NUM_FOND;
    }

    public String getDATE_FOND() {
        return DATE_FOND;
    }

    public void setDATE_FOND(String DATE_FOND) {
        this.DATE_FOND = DATE_FOND;
    }

    public String getLIEU_NAISS_A() {
        return LIEU_NAISS_A;
    }

    public void setLIEU_NAISS_A(String LIEU_NAISS_A) {
        this.LIEU_NAISS_A = LIEU_NAISS_A;
    }

    public int getISOL() {
        return ISOL;
    }

    public void setISOL(int ISOL) {
        this.ISOL = ISOL;
    }

    public String getLIEU_DET() {
        return LIEU_DET;
    }

    public void setLIEU_DET(String LIEU_DET) {
        this.LIEU_DET = LIEU_DET;
    }

    public String getCOD_POSIT() {
        return COD_POSIT;
    }

    public void setCOD_POSIT(String COD_POSIT) {
        this.COD_POSIT = COD_POSIT;
    }

    public String getDAT_POSIT() {
        return DAT_POSIT;
    }

    public void setDAT_POSIT(String DAT_POSIT) {
        this.DAT_POSIT = DAT_POSIT;
    }

    public String getDAT_GRADE_ADM() {
        return DAT_GRADE_ADM;
    }

    public void setDAT_GRADE_ADM(String DAT_GRADE_ADM) {
        this.DAT_GRADE_ADM = DAT_GRADE_ADM;
    }

    public String getDATE_EMB1() {
        return DATE_EMB1;
    }

    public void setDATE_EMB1(String DATE_EMB1) {
        this.DATE_EMB1 = DATE_EMB1;
    }

    public String getDAT_ADM() {
        return DAT_ADM;
    }

    public void setDAT_ADM(String DAT_ADM) {
        this.DAT_ADM = DAT_ADM;
    }

    public String getUNIFORM() {
        return UNIFORM;
    }

    public void setUNIFORM(String UNIFORM) {
        this.UNIFORM = UNIFORM;
    }

    public String getCOD_UR() {
        return COD_UR;
    }

    public void setCOD_UR(String COD_UR) {
        this.COD_UR = COD_UR;
    }

    public String getGRADE_ADM_EMB() {
        return GRADE_ADM_EMB;
    }

    public void setGRADE_ADM_EMB(String GRADE_ADM_EMB) {
        this.GRADE_ADM_EMB = GRADE_ADM_EMB;
    }

    public String getANC_GRADE_ADM() {
        return ANC_GRADE_ADM;
    }

    public void setANC_GRADE_ADM(String ANC_GRADE_ADM) {
        this.ANC_GRADE_ADM = ANC_GRADE_ADM;
    }

    public String getBON_REST() {
        return BON_REST;
    }

    public void setBON_REST(String BON_REST) {
        this.BON_REST = BON_REST;
    }

    public String getCOD_AFF() {
        return COD_AFF;
    }

    public void setCOD_AFF(String COD_AFF) {
        this.COD_AFF = COD_AFF;
    }

    public String getCOD_EQUIP() {
        return COD_EQUIP;
    }

    public void setCOD_EQUIP(String COD_EQUIP) {
        this.COD_EQUIP = COD_EQUIP;
    }

    public String getLIB_FONCT_AFF() {
        return LIB_FONCT_AFF;
    }

    public void setLIB_FONCT_AFF(String LIB_FONCT_AFF) {
        this.LIB_FONCT_AFF = LIB_FONCT_AFF;
    }

    public String getLIB_FONCT_AFF_A() {
        return LIB_FONCT_AFF_A;
    }

    public void setLIB_FONCT_AFF_A(String LIB_FONCT_AFF_A) {
        this.LIB_FONCT_AFF_A = LIB_FONCT_AFF_A;
    }

    public String getROWID() {
        return ROWID;
    }

    public void setROWID(String ROWID) {
        this.ROWID = ROWID;
    }

    @Id
    private String Mat_Pers;

    private String MDP;
    private String COD_DEPT ;

    private String COD_SERV ;

    private String COD_FONCT ;

    private int COD_CATEG ;


    private int COD_CAT ;

    private int COD_GRAD ;

    private String COD_MOTIF;
    private String COD_NATP ;
    private int COD_STAT ;
    private String NOM_PERS ;
    private String PREN_PERS ;
    private String CIN;
    private String SEXE ;
    private String DAT_DEPT ;
    private String DAT_SERV ;
    private String DAT_FONCT ;
    private String DAT_QUALF ;
    private String DAT_CATEG ;
    private String DAT_CAT ;
    private String DAT_GRAD ;
    private String DAT_ECH ;
    private String DAT_EMB ;
    private String DAT_ENT ;
    private String DAT_TIT ;
    private String DAT_MOTIF ;
    private String DAT_NAIS ;
    private String COD_GOUV ;
    private String COD_DELEG ;
    private String COD_POST ;
    private String COD_RETR ;
    private String ETAT_ACT ;
    private String  PER_MAT_PERS ;
    private String  QUALF ;
    private String COD_SIT ;
    private String DAT_SIT ;
    private String CHEF_FAM ;
    private  int NBRE_ENF ;
    private String CHARG_ENF ;
    private  String CHARG_ALL ;
    private  String FCT_FAM ;
    private int COD_ECH ;
    private  String COD_AFFECT ;
    private int CATEG_EMB ;
    private int CAT_EMB;
    private int GRAD_EMB;
    private int  ECH_EMB ;
    private String COD_NIVEAU ;
    private String DAT_RETR ;
    private  String DAT_DECE ;
    private String COD_REG ;
    private String REPOS_HBD ;
    private  String SUSPENS_ASS ;
    private String DAT_DEB_SUSPENS ;
    private String DAT_FIN_SUSPENS ;
    private  String MOTIF_SUSPENS ;
    private String FORM_PERS ;
    private  String COMPTE_HERIT ;
    private   String BENEF ;
    private String NOM_JF ;
    private String DEPT_EMB ;
    private String COMPTE_PROCED_JUDIC;
    private String BENEF_PROCED_JUDIC ;
    private String COD_BAT ;
    private String COD_BUR ;
    private String NOM_PERS_A ;
    private  String PREN_PERS_A ;
    private  String COD_FILL ;
    private  String DAT_FILL ;
    private String POSTE_TRAV ;
    private  String GRADE_ADM ;
    private  String COD_METIER ;
    private String REGIME_TRAV ;
    private String COD_USER ;
    private String DAT_EFFET ;
    private String TYPE_SERV ;
    private String REG_CNG ;
    private String ADM_TECH ;
    private String DAT_STAT ;
    private String DAT_CIN ;
    private String LIE_EMI_CIN ;
    private String DAT_AFFECT ;
    private String LIEU_NAIS ;
    private String COD_LIEU_GEOG ;
    private String DAT_LIEU_GEOG ;
    private String  FORM_PERS_A ;
    private String  AVC ;
    private String AVQ ;
    private  String DAT_AVC ;
    private  String DAT_AVQ ;
    private String  FONCT ;
    private  String AV_VOIT ;
    private String   TRS ;
    private String  DAT_TRS ;
    private String DAT_VOIT ;
    private String  AV_LOG ;
    private String DAT_LOG ;
    private String DAT_FONCT_ANT ;
    private  String COMPTE_DOMIC ;
    private  String NUM_ASS ;
    private String GRP_SANG ;
    private String  POINTE ;
    private  int TYP_CATEG ;
    private  String SERV_MILIT ;
    private  String NUM_RETR ;
    private  String COD_FOND ;
    private  String NUM_FOND ;
    private String DATE_FOND ;
    private String LIEU_NAISS_A ;
    private  int ISOL ;
    private String LIEU_DET ;
    private  String  COD_POSIT ;
    private String DAT_POSIT ;
    private String DAT_GRADE_ADM ;
    private String DATE_EMB1 ;
    private String DAT_ADM ;
    private  String UNIFORM ;
    private String COD_UR ;
    private String GRADE_ADM_EMB ;
    private  String ANC_GRADE_ADM ;
    private String BON_REST ;
    private String COD_AFF ;
    private String COD_EQUIP ;
    private  String  LIB_FONCT_AFF ;
    private String LIB_FONCT_AFF_A ;
    private String  ROWID ;

public String getRole(){
    return role.getRoleName();
}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleID")
    private Role role;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reclamation> reclamation= new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "userF")
    private Set<Forum> forums;

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "personnel", fetch = FetchType.LAZY)
    private List<Agenda> agenda;

    @JsonIgnore
    @OneToMany(mappedBy = "userR")
    private Set<Reply> replies;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority( getRole()));

        return list;

    }

    @Override
    public String getPassword() {
        return MDP;
    }

    @Override
    public String getUsername() {
        return Mat_Pers;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
