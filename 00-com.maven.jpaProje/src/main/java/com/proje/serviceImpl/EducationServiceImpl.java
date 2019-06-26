package com.proje.serviceImpl;

import java.util.List;

import com.proje.dao.EducationDao;
import com.proje.model.Education;
import com.proje.model.daoImpl.EducationDaoImpl;
import com.proje.service.EducationService;

public class EducationServiceImpl implements EducationService {
		
	EducationDao educationService = new EducationDaoImpl();
	
	@Override
	public boolean saveEducation(Education education) {
		// TODO Auto-generated method stub
		return educationService.saveEducation(education);
	}

	@Override
	public boolean updateEducation(Education education) {
		// TODO Auto-generated method stub
		return educationService.updateEducation(education);
	}

	@Override
	public boolean removeEducation(Education education) {
		// TODO Auto-generated method stub
		return educationService.removeEducation(education);
	}

	@Override
	public Education findById(int i) {
		// TODO Auto-generated method stub
		return educationService.findById(i);
	}

	@Override
	public List<Education> findEducations() {
		// TODO Auto-generated method stub
		return educationService.findEducations();
	}

	@Override
	public Education findWithAdvertisementById(int id) {
		// TODO Auto-generated method stub
		return educationService.findWithAdvertisementById(id);
	}

}
