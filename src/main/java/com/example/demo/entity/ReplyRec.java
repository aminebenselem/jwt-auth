package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ReplyRec {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String body;

    public User getUser() {
        return userRec;
    }

    public Reclamation getReclamation() {
        return reclamationR;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamationR= reclamation;
    }
    public void setUser(User userRec) {
        this.userRec = userRec;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mat_Pers")
    private User userRec;




    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rec_id")
    private Reclamation reclamationR;

}

