package com.proje.model.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.sql.ordering.antlr.Factory;

import com.proje.dao.AdvertisementDao;
import com.proje.entityFactory.EntityFactory;
import com.proje.entityFactoryImpl.EntityFactoryImpl;
import com.proje.model.Advertisement;

public class AdvertisementDaoImpl implements AdvertisementDao {

	EntityManagerFactory factory =  Persistence.createEntityManagerFactory("persistence123");
	EntityManager entityManager = factory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	

	@Override
	public boolean saveAdvertisement(Advertisement advertisement) {

		try {
			entityTransaction.begin();
			entityManager.persist(advertisement);
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean updateAdvertisement(Advertisement advertisement) {
		try {
			entityTransaction.begin();
			entityManager.merge(advertisement); 						//Anýnda tabloyu gunceller			
			entityTransaction.commit();

		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public boolean removeAdvertisement(Advertisement advertisement) {
		try {

			if (entityManager.contains(advertisement)) // EntityManager hafýzasýnda boyle býr urun ýcerýp ýcermedýgýne
														// bakýyoruz
			{
				entityManager.remove(advertisement);
			}
			Advertisement deleteAdvertisement = findById(advertisement.getAdvertisementId());//Yoksa hafýzaya sýmdý atarýz
			entityManager.remove(deleteAdvertisement);
		} catch (Exception e) {

			System.out.println("Hata :  " + e);
			entityTransaction.rollback();
			return false;
		}

		return true;
	}

	@Override
	public Advertisement findById(int id) {
		
		Advertisement advertisement=null;
		
		try {
			TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findById", Advertisement.class);
			typedQuery.setParameter("advertisementId", id);
			advertisement = typedQuery.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata  :   "+ e);

		}
		return advertisement;
	}

	@Override
	public List<Advertisement> findByUserName(String userName) {
		List<Advertisement> advertisements=null;
		
		try {
			TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findById", Advertisement.class);
			typedQuery.setParameter("userName", userName);
			advertisements = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Hata  :   "+ e);
		}
		return advertisements;
	}

	@Override
	public List<Advertisement> findAdvertisements() {
			List<Advertisement> advertisements=null;
		
		try {
			TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			advertisements = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Hata  :   "+ e);
		}
		return advertisements;	
	}

	@Override
	public List<Advertisement> findAdvertisementEntities(int firstResult, int maxResult) {
	List<Advertisement> advertisements=null;
		
		try {
			TypedQuery<Advertisement> typedQuery = entityManager.createNamedQuery("Advertisement.findAdvertisements", Advertisement.class);
			typedQuery.setFirstResult(firstResult);
			typedQuery.setMaxResults(maxResult);
			advertisements = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println("Hata  :   "+ e);
		}
		return advertisements;
	}

}
