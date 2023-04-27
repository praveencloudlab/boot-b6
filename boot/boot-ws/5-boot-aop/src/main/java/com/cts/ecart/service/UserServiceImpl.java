package com.cts.ecart.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
	
	
	public String registerUser(String userName) {
		System.out.println(">> User is registered..");
		return userName;
	}
	
	public void findAllUsers() {
		System.out.println("Finding all users");
	}
	
	public void findById() {
		System.out.println("Finding user by user ID");
	}
	
	public void findByName() {
		System.out.println("Finding user by user Name");
	}
	
	public void findByEmail() {
		System.out.println("Finding user by user Email");
	}
	
	public void findByPhoneNumber() {
		System.out.println("Finding user by user Phone Number");
	}
	
	
	

}
