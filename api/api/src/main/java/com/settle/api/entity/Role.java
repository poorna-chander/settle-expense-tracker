package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roles")
    private String role;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User userDetails;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
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
            " id='" + getId() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
    
}
