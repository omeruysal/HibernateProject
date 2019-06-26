package com.proje.model.daoImpl;

import java.util.List;

import javax.enterprise.inject.Typed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;
import com.proje.dao.EducationDao;
import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactoryImpl.EntityFactoryImpl;
import com.proje.model.Advertisement;
import com.proje.model.Education;

public class EducationDaoImpl implements EducationDao {

	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("persistence123");
	EntityManager entityManager = factory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	@Override
	public boolean saveEducation(Education education) {
		try {
			entityTransaction.begin();
			entityManager.persist(education);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean updateEducation(Education education) {
		try {
			entityTransaction.begin();
			entityManager.merge(education);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean removeEducation(Education education) {
		try {

			if (entityManager.contains(education)) // EntityManager hafýzasýnda boyle býr urun ýcerýp ýcermedýgýne
														// bakýyoruz
			{
				entityManager.remove(education);
			}
			Education deleteEducation = findById(education.getEducationId());//Yoksa hafýzaya sýmdý atarýz
			entityManager.remove(deleteEducation);
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public Education findById(int id) {
		Education education = null;
		try {
			TypedQuery<Education> typedQuery = entityManager.createNamedQuery("Education.findById", Education.class);
			typedQuery.setParameter("educationId", id);
			education = typedQuery.getSingleResult();
			
			
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			
		}
		return education;
	}

	@Override
	public List<Education> findEducations() {
		List<Education> educations = null;
		try {
			TypedQuery<Education> typedQuery = entityManager.createNamedQuery("Education.findById", Education.class);
			educations = typedQuery.getResultList();
			
			
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			
		}
		return educations;
	}

	@Override
	public Education findWithAdvertisementById(int id) {
		Education education = null;
		try {
			TypedQuery<Education> typedQuery = entityManager.createNamedQuery("Education.findWithAdvertisementById", Education.class);
			typedQuery.setParameter("educationId", id);
			education = typedQuery.getSingleResult();
			
			
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			
		}
		return education;
	}

}
