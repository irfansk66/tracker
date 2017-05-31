package com.pup.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.pup.entity.Alert;


@Repository
public class AlertRepositoryImpl implements AlertRepository {
	
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void rpmAlert(Alert rpm) {
		// TODO Auto-generated method stub
		em.persist(rpm);
		
	}

	@Override
	public void fuelVolumeAlert(Alert fuelVol) {
		// TODO Auto-generated method stub
		em.persist(fuelVol);
		
	}

	@Override
	public void speedAlert(Alert speed) {
		// TODO Auto-generated method stub
		
		em.persist(speed);
		
	}

	@Override
	public void tireAlert(Alert tire) {
		// TODO Auto-generated method stub
		
		em.persist(tire);
		
	}

	@Override
	public void coolantAlert(Alert coolant) {
		// TODO Auto-generated method stub
		em.persist(coolant);
	}


		
}

