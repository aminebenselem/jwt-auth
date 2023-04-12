package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Reclamation")
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public int getReplycount() {
        return replycount;
    }

    public void setReplycount(int replycount) {
        this.replycount = replycount;
    }

    private  int replycount;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private  String departement ;
    private String email ;
    private String subject ;
    private String message  ;

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return userM;
    }

    public void setUser(User user) {
        this.userM = user;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mat_Pers",
            foreignKey = @ForeignKey(
            name = "fkey_Mat_pers"
    ))
    @OneToMany
    private User userM;

    public List<ReplyRec> getReplyRecList() {
        return replyRecList;
    }

    public void setReplyRecList(List<ReplyRec> replyRecList) {
        this.replyRecList = replyRecList;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "reclamationR")
    private List<ReplyRec> replyRecList;

    public void setMessage(String message) {
        this.message = message;
    }
}