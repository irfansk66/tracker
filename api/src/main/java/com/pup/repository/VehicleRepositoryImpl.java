package com.pup.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pup.entity.Vehicle;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Vehicle findOne(String vinId) {
		// TODO Auto-generated method stub
		return em.find(Vehicle.class, vinId);
	}


	@Override
	public void delete(Vehicle car) {
		// TODO Auto-generated method stub
		
		em.remove(car);
		
	}

	@Override
	public void createVehicle(Vehicle car) {
		
		em.persist(car);
		System.out.println("createmethod rep update success!!");
		
	}

	@Override
	public void updateVehicle(Vehicle car) {
		// TODO Auto-generated method stub
		em.merge(car);
		System.out.println("updatemethod rep update success!!");
	}

}
