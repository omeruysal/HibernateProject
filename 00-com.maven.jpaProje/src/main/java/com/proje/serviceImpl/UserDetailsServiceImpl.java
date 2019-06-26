package com.proje.serviceImpl;

import com.proje.dao.UserDetailsDao;
import com.proje.model.UserDetails;
import com.proje.model.daoImpl.UserDetailsDaoImpl;
import com.proje.service.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {
	UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();
	@Override
	public boolean saveUserDetails(UserDetails userDetails) {
	
		return userDetailsDao.saveUserDetails(userDetails);
	}

	@Override
	public boolean updateDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userDetailsDao.updateDetails(userDetails);
	}

	@Override
	public boolean removeUserDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userDetailsDao.removeUserDetails(userDetails);
	}

	@Override
	public UserDetails findById(int id) {
		
		return userDetailsDao.findById(id);
	}

	@Override
	public UserDetails findByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDetailsDao.findByUserName(userName);
	}

	@Override
	public UserDetails findWithAdressByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDetailsDao.findWithAdressByUserName(userName);
	}

	@Override
	public UserDetails findWithAdvertisementByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDetailsDao.findWithAdvertisementByUserName(userName);
	}

}
