package com.proje.serviceImpl;

import java.util.List;

import com.proje.dao.AdvertisementDao;
import com.proje.model.Advertisement;
import com.proje.model.daoImpl.AdvertisementDaoImpl;
import com.proje.service.AdvertisementService;

public class AdvertisementServiceImpl implements AdvertisementService {
	AdvertisementDao advertisementDao = new AdvertisementDaoImpl();
	@Override
	public boolean saveAdvertisement(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return advertisementDao.saveAdvertisement(advertisement);
	}

	@Override
	
	public boolean updateAdvertisement(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return advertisementDao.updateAdvertisement(advertisement);
	}

	@Override
	public boolean removeAdvertisement(Advertisement advertisement) {
		// TODO Auto-generated method stub
		return advertisementDao.removeAdvertisement(advertisement);
	}

	@Override
	public Advertisement findById(int id) {
		// TODO Auto-generated method stub
		return advertisementDao.findById(id);
	}

	@Override
	public List<Advertisement> findByUserName(String userName) {
		// TODO Auto-generated method stub
		return advertisementDao.findByUserName(userName);
	}

	@Override
	public List<Advertisement> findAdvertisements() {
		// TODO Auto-generated method stub
		return advertisementDao.findAdvertisements();
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return advertisementDao.findAdvertisementEntities(firstResult, maxResult);
	}

}
