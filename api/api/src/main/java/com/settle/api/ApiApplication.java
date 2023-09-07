package com.settle.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.settle.api.dao.AppDao;
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
			getUserWithRolesByEmail(appDao);
		};
	}

	

	private void createUser(AppDao appDao) {
		User user = new User("ram","ram123","ram@settle.com");
		Role role = new Role("admin");
		
		user.addRole(role);
		System.out.println("Saving Usser: " + user);
		appDao.saveUser(user);
		System.out.println("Done!");
	}

	private void getUserByEmail(AppDao appDao) {
		User retUser = appDao.getUserByEmail("@stettle.com");
		System.out.println("name: " + retUser.getUserName());
		System.out.println("pssd: " + retUser.getEncPassword());
		System.out.println("roles: "+ retUser.getRoles());

	}

	private void getUserWithRolesByEmail(AppDao appDao) {
		User retUser = appDao.getUserWithRolesByEmail("@stettle.com");
		System.out.println("name: " + retUser.getUserName());
		System.out.println("pssd: " + retUser.getEncPassword());
		System.out.println("roles: "+ retUser.getRoles());
	}
}
