package com.proje.model.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.dao.UserDetailsDao;
import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactoryImpl.EntityFactoryImpl;
import com.proje.model.*;
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	EntityFactory entityFactory = new EntityFactoryImpl();
	EntityManager entityManager = entityFactory.getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public boolean saveUserDetails(UserDetails userDetails) {

		try {
			entityTransaction.begin();
			entityManager.persist(userDetails);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean updateDetails(UserDetails userDetails) {
		try {
			entityTransaction.begin();
			entityManager.merge(userDetails);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}
	

	@Override
	public boolean removeUserDetails(UserDetails userDetails) {
		try {

			if (entityManager.contains(userDetails)) // EntityManager hafýzasýnda boyle býr urun ýcerýp ýcermedýgýne
														// bakýyoruz
			{
				entityManager.remove(userDetails);
			}
			UserDetails deleteUserDetails = findById(userDetails.getUserDetailId());//Yoksa hafýzaya sýmdý atarýz
			entityManager.remove(deleteUserDetails);
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public UserDetails findById(int id) {
		UserDetails userDetail = null;
	try {
		TypedQuery<UserDetails> typedQuery = entityManager.createNamedQuery("UserDetails.findById", UserDetails.class);
		typedQuery.setParameter("userId", id);
		userDetail = typedQuery.getSingleResult();
		
	} catch (Exception e) {
		System.out.println("Hata   :  "+e);
	}
		return userDetail;
	}

	@Override
	public UserDetails findByUserName(String userName) {
		UserDetails userDetail = null;
		try {
			TypedQuery<UserDetails> typedQuery = entityManager.createNamedQuery("UserDetails.findByUserName", UserDetails.class);
			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return userDetail;
	}

	@Override
	public UserDetails findWithAdressByUserName(String userName) {
		UserDetails userDetail = null;
		try {
			TypedQuery<UserDetails> typedQuery = entityManager.createNamedQuery("UserDetails.findWithAdressesByUserName", UserDetails.class);
			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return userDetail;
	}

	@Override
	public UserDetails findWithAdvertisementByUserName(String userName) {
		UserDetails userDetail = null;
		try {
			TypedQuery<UserDetails> typedQuery = entityManager.createNamedQuery("UserDetails.findWithAdrvertisementByUserName", UserDetails.class);
			typedQuery.setParameter("userName", userName);
			userDetail = typedQuery.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return userDetail;
	}

}
