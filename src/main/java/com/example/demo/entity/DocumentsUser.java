package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "DocumentUser")
public class DocumentsUser {





        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  long id ;
        private String uri;
        private String name ;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public User getUserD() {
            return userD;
        }

        public void setUserD(User userD) {
            this.userD = userD;
        }

        @JsonIgnore
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "Mat_Pers")
        private User userD;
    }


