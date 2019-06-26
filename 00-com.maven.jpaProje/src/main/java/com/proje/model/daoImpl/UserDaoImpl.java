package com.proje.model.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.proje.dao.UserDao;
import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactoryImpl.EntityFactoryImpl;
import com.proje.model.User;
import com.proje.model.UserDetails;

public class UserDaoImpl implements UserDao{


	EntityFactory entityFactory = new EntityFactoryImpl();
	EntityManager entityManager = entityFactory.getEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	@Override
	public boolean saveUser(User user) {
		try {
			entityTransaction.begin();
			entityManager.persist(user);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			entityTransaction.begin();
			entityManager.merge(user);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean removeUser(User user) {
		try {

			if (entityManager.contains(user)) // EntityManager hafýzasýnda boyle býr urun ýcerýp ýcermedýgýne
														// bakýyoruz
			{
				entityManager.remove(user);
			}
			User deleteUser = findById(user.getUserId());		//Yoksa hafýzaya sýmdý atarýz
			entityManager.remove(deleteUser);
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public User findById(int id) {
		User user = null;
	try {
		TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findById", User.class);
		typedQuery.setParameter("userId", id);
		user = typedQuery.getSingleResult();
		
	} catch (Exception e) {
		System.out.println("Hata   :  "+e);
	}
		return user;
	}

	@Override
	public User findByUserName(String userName) {
		User user = null;
		try {
			TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findByUserName", User.class);
			typedQuery.setParameter("userName", userName);
			user = typedQuery.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return user;
	}

	@Override
	public User findWithUserDetailsById (int id) {
		User user = null;
		try {
			TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findWithUserDetailsById", User.class);
			typedQuery.setParameter("userId", id);
			user = typedQuery.getSingleResult();
			
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return user;
	}

	@Override
	public List<User> findUsers() {
		List<User> users = null;
		try {
			TypedQuery<User> typedQuery = entityManager.createNamedQuery("User.findUsers", User.class);
			users = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Hata   :  "+e);
		}
			return users;
	}

	@Override
	public List<User> findUsers(int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findUserCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
