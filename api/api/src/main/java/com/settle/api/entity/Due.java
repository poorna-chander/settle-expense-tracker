package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tally")
public class Due {

    @Id
    @Column(name = "user_payer")
    private int userPayerId;

    @Id
    @Column(name = "user_payee")
    private int userPayeeId;

    @Id
    @Column(name = "bill")
    private String billCode;

    @Column(name = "amount")
    private float amount;
    
    @Column(name = "settled")
    private boolean settled;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "bill")
    private Bill bill;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_payer")
    private User payer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_payee")
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

    public Bill getBill() {
        return this.bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public User getPayer() {
        return this.payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getPayee() {
        return this.payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
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
