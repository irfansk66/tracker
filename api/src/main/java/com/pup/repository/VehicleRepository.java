package com.pup.repository;

import com.pup.entity.Vehicle;

public interface VehicleRepository {
	
	Vehicle findOne(String vinId);
	
	 void createVehicle(Vehicle car);
	 void updateVehicle(Vehicle car);
	void delete(Vehicle car);


}
