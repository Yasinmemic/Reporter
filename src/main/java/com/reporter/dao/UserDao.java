package com.reporter.dao;

import java.util.List;

import com.reporter.entity.Users;

public interface UserDao {
	void insertUser(Users user);
	void insertUsers(List<Users> users);
	List<Users> getAllUsers();
	Users getUserById(String userId);
}