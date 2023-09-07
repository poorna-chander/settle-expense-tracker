package com.settle.api;

import java.time.Instant;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.settle.api.dao.AppDao;
import com.settle.api.entity.Bill;
import com.settle.api.entity.Item;
import com.settle.api.entity.Role;
import com.settle.api.entity.User;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		
		return runner -> {
			// createUser(appDao);
			// getUserByEmail(appDao);
			// getUserWithRolesByEmail(appDao);
			// addBill(appDao);
			// addBillWithItemSplits(appDao);
			// getBillsByPayer(appDao);
			getItemsByBillCode(appDao);
			// addItemToBillCode(appDao);
		};
	}

	

	private void addItemToBillCode(AppDao appDao) {
		int[] itmInvolved = {4};
		Item item = new Item("chicken", 2, 6f, itmInvolved);
		appDao.addItemToBill("2023-09-07T16:20:47.159735992Z_2_2", item);
	}

	private void getBillsByPayer(AppDao appDao) {
		List<Bill> bills = appDao.getBillsOnlyByPayer(2);
		for (Bill bill : bills) {
			System.out.println(bill);
		}

	}

	private void getItemsByBillCode(AppDao appDao){
		List<Item> items = appDao.getItemsWithBillCode("2023-09-07T16:20:47.159735992Z_2_2");
		for (Item item: items){
			System.out.println(item);
			System.out.println(item.getBill());
		}
	}
	

	private void addBillWithItemSplits(AppDao appDao) {
		int store = 2;
		String date = "28-03-2023";
		int payer = 2;
		int[] involved = {2,4};
		Instant currentInstant = Instant.now();
		String isoString = currentInstant.toString();
		String billCode = isoString+"_"+store+"_"+payer;
		Bill bill = new Bill(billCode, store, date, payer, involved);
		//String itemName, String billCode, int Quantity, float price, int[] usersInvolvedItem
		int[] itmInvolved = {2,4};
		Item item = new Item("tide pods", 2, 17.5f, itmInvolved);
		bill.addItem(item);
		System.out.println("SAVING BILL..");
		appDao.saveBill(bill);
		System.out.println("DONE!");
	}

	private void addBill(AppDao appDao) {
		int store = 1;
		String date = "28-03-2023";
		int payer = 2;
		int[] involved = {1};
		Instant currentInstant = Instant.now();
		String isoString = currentInstant.toString();
		Bill bill = new Bill(isoString+"_"+store+"_"+payer, store, date, payer, involved);
		appDao.saveBill(bill);

	}

	private void createUser(AppDao appDao) {
		User user = new User("rishi","rishi123","rishi@settle.com");
		// Role role = new Role("admin");
		Role role2 = new Role("user");
		
		// user.addRole(role);
		user.addRole(role2);
		System.out.println("Saving Usser: " + user);
		appDao.saveUser(user);
		System.out.println("Done!");
	}

	private void getUserByEmail(AppDao appDao) {
		User retUser = appDao.getUserByEmail("@stettle.com");
		System.out.println("name: " + retUser.getUserName());
		System.out.println("pssd: " + retUser.getEncPassword());
		// System.out.println("roles: "+ retUser.getRoles());

	}

	private void getUserWithRolesByEmail(AppDao appDao) {
		User retUser = appDao.getUserWithRolesByEmail("@stettle.com");
		System.out.println("name: " + retUser.getUserName());
		System.out.println("pssd: " + retUser.getEncPassword());
		System.out.println("roles: "+ retUser.getRoles());
	}
}
