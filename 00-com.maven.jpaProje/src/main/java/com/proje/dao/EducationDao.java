package com.proje.dao;

import java.util.List;

import com.proje.model.Education;

public interface EducationDao {
	
	boolean saveEducation(Education education);
	boolean updateEducation(Education education);
	boolean removeEducation(Education education);
	
	Education findById(int i);
	
	List<Education> findEducations();
	
	Education findWithAdvertisementById(int id);


	

}
