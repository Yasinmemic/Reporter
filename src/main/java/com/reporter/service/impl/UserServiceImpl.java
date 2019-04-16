package com.reporter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporter.dao.UserDao;
import com.reporter.entity.Users;
import com.reporter.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void insertUser(Users user) {
		userDao.insertUser(user);
	}

	@Override
	public void insertUsers(List<Users> users) {
		userDao.insertUsers(users);
	}

	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void getUserById(String userId) {
		Users user = userDao.getUserById(userId);
		System.out.println(user);
	}

}