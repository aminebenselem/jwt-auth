package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "DemandesAdministratif")
public class DemandesAdministratif {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private  String type;
    private String  proved;
    private String uri;
    private String uri1 ;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "Mat_Pers")
    private User userA;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProved() {
        return proved;
    }

    public void setProved(String proved) {
        this.proved = proved;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUri1() {
        return uri1;
    }

    public void setUri1(String uri1) {
        this.uri1 = uri1;
    }

    public User getUser() {
        return userA;
    }

    public void setUserA(User userA) {
        this.userA = userA;
    }
}
