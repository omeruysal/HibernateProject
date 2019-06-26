package com.proje.dao;

import java.util.List;

import com.proje.model.User;

public interface UserDao {

	boolean saveUser (User user);
	
	boolean updateUser (User user);
	
	boolean  removeUser(User user);
	
	User findById(int id);
	
	User findByUserName(String userName);
	
	User findWithUserDetailsById(int id);
	
	List <User> findUsers();
	
	List<User> findUsers(int firstResult,int maxResult);
	
	int findUserCount();
	
	
	
}
