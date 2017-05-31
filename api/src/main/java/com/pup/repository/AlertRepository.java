package com.pup.repository;

import com.pup.entity.Alert;

public interface AlertRepository {
	
	
	void rpmAlert(Alert rpm);
	void fuelVolumeAlert(Alert fuelVol);
	void speedAlert( Alert speed);
	void tireAlert(Alert tire);
	void coolantAlert(Alert coolant);
	

}
