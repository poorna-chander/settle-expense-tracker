package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Friends")
public class Network {
    
    @Id
    @Column(name = "UserTo")
    private int userToId;

    @Id
    @Column(name = "UserFrom")
    private int userFromId;

    @Column(name = "Status")
    private int requestStatusCode;

    @Column(name = "Time")
    private String latestStatusTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "UserTo")
    private User sendUser;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "UserFrom")
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
