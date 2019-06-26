package com.proje.dao;

import java.util.List;

import com.proje.model.Advertisement;

public interface AdvertisementDao {
	
	boolean saveAdvertisement(Advertisement advertisement);
	boolean updateAdvertisement(Advertisement advertisement);
	boolean removeAdvertisement(Advertisement advertisement);
	Advertisement findById(int id);
	List<Advertisement> findByUserName(String userName);
	
	List<Advertisement> findAdvertisements();
	
	List<Advertisement> findAdvertisementEntities(int firstResult,int maxResult);

}
