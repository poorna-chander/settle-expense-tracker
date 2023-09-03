package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserRoles")
public class Role {

    @Id
    @Column(name = "User")
    private int user;

    @Column(name = "Roles")
    private int role;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "User")
    private User userDetails;

    public Role() {
    }

    public Role(int user, int role) {
        this.user = user;
        this.role = role;
    }


    public int getUser() {
        return this.user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public User getUserDetails() {
        return this.userDetails;
    }

    public void setUserDetails(User userDetails) {
        this.userDetails = userDetails;
    }


    @Override
    public String toString() {
        return "{" +
            " user='" + getUser() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
    
}
