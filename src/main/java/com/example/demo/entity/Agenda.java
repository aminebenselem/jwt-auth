//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    private String Task;
    private String Date;
    @JsonIgnore
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "Mat_Pers",
            foreignKey = @ForeignKey(
                    name = "fkey_Mat_pers"
            )
    )
    private User personnel;

    public Agenda() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return this.Task;
    }

    public void setTask(String task) {
        this.Task = task;
    }

    public String getDate() {
        return this.Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public User getUser() {
        return this.personnel;
    }

    public void setUser(User user) {
        this.personnel = user;
    }
}
