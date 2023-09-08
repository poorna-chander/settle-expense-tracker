package com.settle.api.dao;

import java.util.List;

import com.settle.api.entity.Bill;
import com.settle.api.entity.Item;
import com.settle.api.entity.User;

public interface AppDao {

    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserWithRolesByEmail(String email);

    void saveBill(Bill bill);
    List<Bill> getBillsOnlyByPayer(int payerId);
    Bill getBillOnlyByCode(String billCode);
    List<Item> getItemsWithBillCode(String billCode);
    void addItemToBill(String billCode, Item item);
    void updateItemPrice(Bill bill, String itemName, float price);
    void updateItemPrice(String billCode, String itemName, float price);

    
}
