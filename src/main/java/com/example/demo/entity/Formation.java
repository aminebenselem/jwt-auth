//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(
        name = "formation"
)
public class Formation {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String categorie;
    private String theme;
    private String datedb;
    private String datefn;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    private String formateur;
    private String Cabinet;
    private String uri;

    public Formation() {
    }

    public String getCabinet() {
        return this.Cabinet;
    }

    public void setCabinet(String cabinet) {
        this.Cabinet = cabinet;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTheme() {
        return this.theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDatedb() {
        return this.datedb;
    }

    public void setDatedb(String datedb) {
        this.datedb = datedb;
    }

    public String getDatefn() {
        return this.datefn;
    }

    public void setDatefn(String datefn) {
        this.datefn = datefn;
    }

    public String getFormateur() {
        return this.formateur;
    }

    public void setFormateur(String formateur) {
        this.formateur = formateur;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
    @JsonIgnore
    @ManyToMany(mappedBy = "mesFormation",cascade=CascadeType.ALL)
    Set<User> users;
}
