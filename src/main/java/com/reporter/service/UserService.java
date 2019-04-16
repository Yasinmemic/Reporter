package com.reporter.service;

import java.util.List;

import com.reporter.entity.Users;

public interface UserService {
	void insertUser(Users user);
	void insertUsers(List<Users> users);
	List<Users> getAllUsers();
	void getUserById(String userid);
}