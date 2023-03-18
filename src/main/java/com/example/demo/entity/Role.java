package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    private String roleID;
    private String roleName;



    public String getRoleID() {
        return roleID;
    }
    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();

}