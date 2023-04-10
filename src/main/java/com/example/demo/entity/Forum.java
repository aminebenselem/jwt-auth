package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Forum {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return userF;
    }

    public void setUser(User user) {
        this.userF = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private  String body;
    private int replicount;
    public int getReplicount() {
        return replicount;
    }

    public void setReplicount(int replicount) {
        this.replicount = replicount;
    }



    public User getUserF() {
        return userF;
    }

    public void setUserF(User userF) {
        this.userF = userF;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Mat_Pers")
    private User userF;


    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "forumR")
    private List<Reply> replies;

}
