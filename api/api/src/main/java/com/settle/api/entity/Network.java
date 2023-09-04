package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "friends")
public class Network {
    
    @Id
    @Column(name = "user_to")
    private int userToId;

    @Id
    @Column(name = "user_from")
    private int userFromId;

    @Column(name = "status")
    private int requestStatusCode;

    @Column(name = "time")
    private String latestStatusTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_to")
    private User sendUser;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_from")
    private User acceptUser;

    public Network() {
    }


    public Network(int userToId, int userFromId, int requestStatusCode, String latestStatusTime) {
        this.userToId = userToId;
        this.userFromId = userFromId;
        this.requestStatusCode = requestStatusCode;
        this.latestStatusTime = latestStatusTime;
    }


    public int getUserToId() {
        return this.userToId;
    }

    public void setUserToId(int userToId) {
        this.userToId = userToId;
    }

    public int getUserFromId() {
        return this.userFromId;
    }

    public void setUserFromId(int userFromId) {
        this.userFromId = userFromId;
    }

    public int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public void setRequestStatusCode(int requestStatusCode) {
        this.requestStatusCode = requestStatusCode;
    }

    public String getLatestStatusTime() {
        return this.latestStatusTime;
    }

    public void setLatestStatusTime(String latestStatusTime) {
        this.latestStatusTime = latestStatusTime;
    }

    public User getSendUser() {
        return this.sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public User getAcceptUser() {
        return this.acceptUser;
    }

    public void setAcceptUser(User acceptUser) {
        this.acceptUser = acceptUser;
    }


    @Override
    public String toString() {
        return "{" +
            " userToId='" + getUserToId() + "'" +
            ", userFromId='" + getUserFromId() + "'" +
            ", requestStatusCode='" + getRequestStatusCode() + "'" +
            ", latestStatusTime='" + getLatestStatusTime() + "'" +
            "}";
    }


}
