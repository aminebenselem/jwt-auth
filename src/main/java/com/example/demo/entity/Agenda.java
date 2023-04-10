package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Proxy;


@Entity
public class Agenda {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public User getUser() {
        return personnel;
    }

    public void setUser(User user) {
        this.personnel = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;
    private String Task;
    private String Date ;



    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "Mat_Pers",
            foreignKey = @ForeignKey(
                    name = "fkey_Mat_pers"
            )
    )
    private User personnel;
}