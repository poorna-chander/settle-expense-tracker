package com.settle.api;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.settle.api.dao.AppDao;
import com.settle.api.entity.Bill;
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
			addBill(appDao);
		};
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
		User user = new User("poorna","pcr123","poorna@settle.com");
		Role role = new Role("admin");
		Role role2 = new Role("user");
		
		user.addRole(role);
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
