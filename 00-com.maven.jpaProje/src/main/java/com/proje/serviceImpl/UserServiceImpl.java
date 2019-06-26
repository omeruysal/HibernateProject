package com.proje.serviceImpl;

import java.util.List;

import com.proje.dao.UserDao;
import com.proje.model.User;
import com.proje.model.UserDetails;
import com.proje.model.daoImpl.UserDaoImpl;
import com.proje.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();	
	
	@Override
	public boolean saveUser(User user) {
		
		return this.userDao.saveUser(user);
	}

	@Override
	public boolean updateUser(User user) {
	
		return this.userDao.updateUser(user);
	}

	@Override
	public boolean removeUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.removeUser(user);
	}

	@Override
	public User findById(int id) {
		
		return this.userDao.findById(id);
	}

	@Override
	public User findByUserName(String userName) {
		
		return this.userDao.findByUserName(userName);
	}

	@Override
	public User findWithUserDetailsById(int id) {
		
		return this.userDao.findWithUserDetailsById(id);
	}

	@Override
	public List<User> findUsers() {	
		return this.userDao.findUsers();
	}

	@Override
	public List<User> findUsers(int firstResult, int maxResult) {
		
		return this.userDao.findUsers(firstResult, maxResult);
	}

	@Override
	public int findUserCount() {
		
		return this.userDao.findUserCount();
	}
	
	
}
