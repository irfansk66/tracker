package com.pup.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import com.pup.entity.Alert;
import com.pup.entity.HighAlert;


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

	@Override
	public List<Alert> findAll() {
		// TODO Auto-generated method stub

		 List<Alert> l = em.createQuery(
			        "SELECT a.vin, a.priority,count(a.vin) as CountofAlerts FROM Alert a "
			        + "WHERE a.timestamp > ( now() - 7200 ) and a.priority='High' GROUP BY a.vin ORDER BY CountofAlerts DESC")
			        .getResultList();
		
		return l;
	}

	@Override
	public List<Alert> findAllHistoricalAlertsOfVehicle(String vin) {
		// TODO Auto-generated method stub
		
		TypedQuery<Alert> query = em.createNamedQuery("Alert.findAllVehicleAlerts",Alert.class);
		query.setParameter("avin", vin);
		return query.getResultList();
	}


		
}

