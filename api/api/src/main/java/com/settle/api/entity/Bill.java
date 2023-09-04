package com.settle.api.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

    

@Entity
@Table(name = "bills")
public class Bill {
    
    @Id
    @Column(name = "bill")
    private String billCode;

    @Column(name = "store")
    private int store;

    @Column(name = "date")
    private String date;

    @Column(name = "payer")
    private int payerId;

    @Column(name = "bill_involved")
    private int[] billParticipantIds;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Due> dues;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    private List<Item> items;


    public Bill() {
    }


    public Bill(String billCode, int store, String date, int payerId, int[] billParticipantIds) {
        this.billCode = billCode;
        this.store = store;
        this.date = date;
        this.payerId = payerId;
        this.billParticipantIds = billParticipantIds;
    }


    public String getBillCode() {
        return this.billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public int getStore() {
        return this.store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPayerId() {
        return this.payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public int[] getBillParticipantIds() {
        return this.billParticipantIds;
    }

    public void setBillParticipantIds(int[] billParticipantIds) {
        this.billParticipantIds = billParticipantIds;
    }

    public List<Due> getDues() {
        return this.dues;
    }

    public void setDues(List<Due> dues) {
        this.dues = dues;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item theItem) {

        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(theItem);

        theItem.setBill(this);
    }

    public void addDue(Due theDue) {

        if (dues == null) {
            dues = new ArrayList<>();
        }

        dues.add(theDue);

        theDue.setBill(this);
    }


    @Override
    public String toString() {
        return "{" +
            " billCode='" + getBillCode() + "'" +
            ", store='" + getStore() + "'" +
            ", date='" + getDate() + "'" +
            ", payerId='" + getPayerId() + "'" +
            ", billParticipantIds='" + getBillParticipantIds() + "'" +
            "}";
    }




}
