package com.settle.api.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.settle.api.entity.Bill;
import com.settle.api.entity.Item;
import com.settle.api.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImp implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public AppDaoImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUserByEmail(String email) {
        
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.email = :data", User.class);

        query.setParameter("data", email);

        List<User> users = query.getResultList();

        // assuming email id unique constrint in RDBMS is working
        return users.get(0);
    }

    @Override
    public User getUserWithRolesByEmail(String email) {

        TypedQuery<User> query = entityManager.createQuery("select u from User u JOIN FETCH u.roles where u.email = :data", User.class);

        query.setParameter("data", email);

        List<User> users = query.getResultList();

        // assuming email id unique constrint in RDBMS is working
        return users.get(0);
        
    }

    @Override
    @Transactional
    public void saveBill(Bill bill) {
        entityManager.persist(bill);
    }

    @Override
    public List<Bill> getBillsOnlyByPayer(int payerId) {
        TypedQuery<Bill> query = entityManager.createQuery("select b from Bill b where b.payerId = :data", Bill.class);

        query.setParameter("data", payerId);

        List<Bill> bills = query.getResultList();

        return bills; 
    }
    

    @Override
    public List<Item> getItemsWithBillCode(String billCode) {
        TypedQuery<Bill> query = entityManager.createQuery("select b from Bill b JOIN FETCH b.items where b.billCode = :data", Bill.class);

        query.setParameter("data", billCode);

        List<Item> items = query.getSingleResult().getItems();

        return items; 
    }

    @Override
    @Transactional
    public void addItemToBill(String billCode, Item item) {
       TypedQuery<Bill> query = entityManager.createQuery("select b from Bill b JOIN FETCH b.items where b.billCode = :data", Bill.class);
       query.setParameter("data", billCode);
       Bill bill = query.getSingleResult();
       bill.addItem(item);
       entityManager.persist(bill);
    }

    @Override
    @Transactional
    public void updateItemPrice(Bill bill, String itemName, float price) {
        TypedQuery<Item> query = entityManager.createQuery("select i from Item i  where i.bill = :billname and i.itemName = :itemname", Item.class);
        query.setParameter("billname", bill).setParameter("itemname", itemName);
        Item item = query.getSingleResult();
        item.setPrice(price);
        entityManager.merge(item);
    }

    @Override
    public Bill getBillOnlyByCode(String billCode) {
        TypedQuery<Bill> query = entityManager.createQuery("select b from Bill b where b.billCode = :data", Bill.class);

        query.setParameter("data", billCode);

        List<Bill> bills = query.getResultList();

        return bills.get(0); 
    }

    @Override
    public void updateItemPrice(String billCode, String itemName, float price) {
        
    }   

    
}
