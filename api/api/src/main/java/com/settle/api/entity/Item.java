package com.settle.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="item_splits")
public class Item {

    @Id
    @Column(name = "item")
    private String itemName;
    
    @Id
    @Column(name = "bill")
    private String billCode;

    @Column(name = "quantity")
    private int Quantity;

    @Column(name = "price")
    private float price;

    @Column(name = "item_involved")
    private int[] usersInvolvedItem;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
        CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "Bill")
    private Bill bill;

    public Item() {
    }
    
    public Item(String itemName, String billCode, int Quantity, float price, int[] usersInvolvedItem) {
        this.itemName = itemName;
        this.billCode = billCode;
        this.Quantity = Quantity;
        this.price = price;
        this.usersInvolvedItem = usersInvolvedItem;
    }


    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBillCode() {
        return this.billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public int getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int[] getUsersInvolvedItem() {
        return this.usersInvolvedItem;
    }

    public void setUsersInvolvedItem(int[] usersInvolvedItem) {
        this.usersInvolvedItem = usersInvolvedItem;
    }

    public Bill getBill() {
        return this.bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }



    @Override
    public String toString() {
        return "{" +
            " itemName='" + getItemName() + "'" +
            ", billCode='" + getBillCode() + "'" +
            ", Quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            ", usersInvolvedItem='" + getUsersInvolvedItem() + "'" +
            "}";
    }



    
    
}
