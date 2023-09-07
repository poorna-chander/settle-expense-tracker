package com.settle.api.dao;

import com.settle.api.entity.Bill;
import com.settle.api.entity.User;

public interface AppDao {

    void saveUser(User user);
    User getUserByEmail(String email);
    User getUserWithRolesByEmail(String email);

    void saveBill(Bill bill);
    
}
