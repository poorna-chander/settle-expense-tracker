package com.settle.api.entity;

import java.util.ArrayList;
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
@Table(name="user_cred")
public class User {

    @Id
    //strategy needs to be updated to custom serial for scalability
    //refer : https://stackoverflow.com/questions/11825643/configure-jpa-to-let-postgresql-generate-the-primary-key-value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int id;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String encPassword;

    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "payer", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Due> duesPayer;

    @OneToMany(mappedBy = "payee", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Due> duesPayee;

    @OneToMany(mappedBy = "sendUser", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Network> requesters;

    @OneToMany(mappedBy = "acceptUser", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Network> accepters;

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

    //***************************************

    public List<Due> getDuesPayer() {
        return this.duesPayer;
    }

    public void setDuesPayer(List<Due> duesPayer) {
        this.duesPayer = duesPayer;
    }

    public List<Due> getDuesPayee() {
        return this.duesPayee;
    }

    public void setDuesPayee(List<Due> duesPayee) {
        this.duesPayee = duesPayee;
    }

    public List<Network> getRequesters() {
        return this.requesters;
    }

    public void setRequesters(List<Network> requesters) {
        this.requesters = requesters;
    }

    public List<Network> getAccepters() {
        return this.accepters;
    }

    public void setAccepters(List<Network> accepters) {
        this.accepters = accepters;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role theRole) {

        if (roles == null) {
            roles = new ArrayList<>();
        }

        roles.add(theRole);

        theRole.setUserDetails(this);
    }

    public void addAccepterRecord(Network accepter) {

        if ( accepters == null) {
            accepters = new ArrayList<>();
        }

        accepters.add(accepter);

        accepter.setAcceptUser(this);
    }

    public void addRequesterRecord(Network requester) {

        if ( requesters == null) {
            requesters = new ArrayList<>();
        }

        requesters.add(requester);

        requester.setAcceptUser(this);
    }

    public void addPayerDueRecord(Due theDue) {

        if ( duesPayer == null) {
            duesPayer = new ArrayList<>();
        }

        duesPayer.add(theDue);

        theDue.setPayer(this);
    }

    public void addPayeeDueRecord(Due theDue) {

        if ( duesPayee == null) {
            duesPayee = new ArrayList<>();
        }

        duesPayee.add(theDue);

        theDue.setPayee(this);
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
