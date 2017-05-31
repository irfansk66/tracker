package com.pup.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pup.entity.Readings;

import com.pup.entity.Vehicle;



@Repository
public class ReadingsRepositoryImpl implements ReadingsRepository  {
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Readings carreadings) {
		// TODO Auto-generated method stub
		
		em.persist(carreadings);
		
		
	}

	@Override
	public Vehicle findveh(String vinNo) {
		// TODO Auto-generated method stub
		return em.find(Vehicle.class, vinNo);
	}

	

}
