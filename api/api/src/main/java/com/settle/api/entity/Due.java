package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tally")
public class Due {

    @Id
    @Column(name = "UserPayer")
    private int userPayerId;

    @Id
    @Column(name = "UserPayee")
    private int userPayeeId;

    @Id
    @Column(name = "Bill")
    private String billCode;

    @Column(name = "Amount")
    private float amount;
    
    @Column(name = "Settled")
    private boolean settled;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Bill")
    private Bill bill;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "UserPayer")
    private User payer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "UserPayee")
    private User payee;

    

    public Due() {
    }


    public Due(int userPayerId, int userPayeeId, String billCode, float amount, boolean settled) {
        this.userPayerId = userPayerId;
        this.userPayeeId = userPayeeId;
        this.billCode = billCode;
        this.amount = amount;
        this.settled = settled;
    }



    public int getUserPayerId() {
        return this.userPayerId;
    }

    public void setUserPayerId(int userPayerId) {
        this.userPayerId = userPayerId;
    }

    public int getUserPayeeId() {
        return this.userPayeeId;
    }

    public void setUserPayeeId(int userPayeeId) {
        this.userPayeeId = userPayeeId;
    }

    public String getBillCode() {
        return this.billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isSettled() {
        return this.settled;
    }

    public boolean getSettled() {
        return this.settled;
    }

    public void setSettled(boolean settled) {
        this.settled = settled;
    }


    @Override
    public String toString() {
        return "{" +
            " userPayerId='" + getUserPayerId() + "'" +
            ", userPayeeId='" + getUserPayeeId() + "'" +
            ", billCode='" + getBillCode() + "'" +
            ", amount='" + getAmount() + "'" +
            ", settled='" + isSettled() + "'" +
            "}";
    }




}
