package com.settle.api.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="UserCred")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
    private int id;

    @Column(name="UserName")
    private String userName;

    @Column(name="Password")
    private String encPassword;

    @Column(name="Email")
    private String email;

    @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Due> duesPayer;

    @OneToMany(mappedBy = "payee", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Due> duesPayee;

    @OneToMany(mappedBy = "sendUser", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Network> senderPovNetwork;

    @OneToMany(mappedBy = "acceptUser", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Network> accepterPovNetwork;

    @OneToMany(mappedBy = "userDetails", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Role> roles;

    public User() {

    }

    public User(String userName, String encPassword, String email) {
        this.userName = userName;
        this.encPassword = encPassword;
        this.email = email;
    }


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncPassword() {
        return this.encPassword;
    }

    public void setEncPassword(String encPassword) {
        this.encPassword = encPassword;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", encPassword='" + getEncPassword() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }

  
}
