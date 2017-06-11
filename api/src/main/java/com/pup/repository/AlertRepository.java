package com.pup.repository;

import java.util.List;

import com.pup.entity.Alert;
import com.pup.entity.HighAlert;

public interface AlertRepository {
	
	
	void rpmAlert(Alert rpm);
	void fuelVolumeAlert(Alert fuelVol);
	void speedAlert( Alert speed);
	void tireAlert(Alert tire);
	void coolantAlert(Alert coolant);
	List<Alert> findAll();
	List<Alert> findAllHistoricalAlertsOfVehicle(String vin);
	

}
