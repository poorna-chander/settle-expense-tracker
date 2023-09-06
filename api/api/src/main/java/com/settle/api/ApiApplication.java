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
			createUser(appDao);
		};
	}

	private void createUser(AppDao appDao) {
		User user = new User("poorna","pcr123","@stetxatle.com");
		Role role = new Role("admin");
		Role role2 = new Role("user");
		
		user.addRole(role);
		user.addRole(role2);
		System.out.println("Saving Usser: " + user);
		appDao.saveUser(user);
		System.out.println("Done!");
	}
}
