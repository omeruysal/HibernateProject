package com.proje.dao;

import com.proje.model.UserDetails;

public interface UserDetailsDao {

	boolean saveUserDetails(UserDetails userDetails);
	boolean updateDetails(UserDetails userDetails);
	boolean removeUserDetails(UserDetails userDetails);
	
	UserDetails findById(int id);
	UserDetails findByUserName(String userName);
	UserDetails findWithAdressByUserName(String userName);
	UserDetails findWithAdvertisementByUserName(String userName);
	

	


	
	
	
}
