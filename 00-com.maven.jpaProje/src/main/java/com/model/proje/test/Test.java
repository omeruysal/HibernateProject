package com.model.proje.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.proje.model.Adress;
import com.proje.model.Advertisement;
import com.proje.model.Education;
import com.proje.model.User;
import com.proje.model.UserDetails;
import com.proje.model.util.PhoneType;
import com.proje.service.AdvertisementService;
import com.proje.service.EducationService;
import com.proje.service.UserDetailsService;
import com.proje.service.UserService;
import com.proje.serviceImpl.AdvertisementServiceImpl;
import com.proje.serviceImpl.EducationServiceImpl;
import com.proje.serviceImpl.UserDetailsServiceImpl;
import com.proje.serviceImpl.UserServiceImpl;

public class Test {
public static void main(String[] args) {
	
		UserService userService = new UserServiceImpl();
		AdvertisementService advertisementService = new AdvertisementServiceImpl();
		EducationService educationService = new EducationServiceImpl();
		UserDetailsService userDetailsService = new UserDetailsServiceImpl();
		
	/*	Education education = new Education("bilgisayar muhendisii");
		
		Advertisement advertisement = new Advertisement("Yazilimci", "buraya aciklama gelicek");
		List<Adress> adress = new Adress("asfsf", "sad", "123", "istanbul");
		UserDetails userDetails = new UserDetails("Omer","Uysal");
		userDetails.setAdresses(adress);

		advertisement.setUserDetails(userDetails);
		education.setEducationName("computerEngineer");*/
		
		Adress adress = new Adress("adres", "road", "zipCode", "city");
		List<Adress> adresses = new ArrayList<>();
		adresses.add(adress);
		
		UserDetails userDetails = new UserDetails("Omer","Uysal");
		User user = new User( userDetails.getFirstName(), "123");
		userDetails.setUser(user);
		userDetails.setAdresses(adresses);
		userService.saveUser(user);
		userDetailsService.saveUserDetails(userDetails);
	
	/*advertisementService.saveAdvertisement(advertisement);
	educationService.saveEducation(education);
	userDetailsService.saveUserDetails(userDetails);*/
}
}
