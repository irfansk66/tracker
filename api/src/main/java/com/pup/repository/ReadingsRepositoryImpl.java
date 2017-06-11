package com.pup.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public List<Readings> geolocations(String VinId) {
		// TODO Auto-generated method stub
		
		 Query l = em.createQuery(
			        "SELECT rdn FROM Readings rdn WHERE rdn.timestamp > (now() - 1800) "
			        + "AND rdn.vin = :v").setParameter("v", VinId);
		 List<Readings> r =l.getResultList();
		
		return r;
	}

	@Override
	public List<Readings> getPlotSignalReadings(String VinId, float range) {
		// TODO Auto-generated method stub
		float t=range;
		Timestamp timestamp1 = new Timestamp((long) (System.currentTimeMillis()-t*60*1000));
        System.out.println(timestamp1);
		Query p = em.createQuery(
		        "SELECT rdn FROM Readings rdn WHERE rdn.timestamp > :timestamp1 "
		        + "AND rdn.vin = :v").setParameter("v", VinId).setParameter("timestamp1", timestamp1);
	 List<Readings> m =p.getResultList();
	
		
		return  m;
	}

	

}
