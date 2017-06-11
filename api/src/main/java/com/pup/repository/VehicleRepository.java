package com.pup.repository;

import java.util.List;

import com.pup.entity.Vehicle;

public interface VehicleRepository {
	
	Vehicle findOne(String vinId);
	List<Vehicle> findAll();
	void createVehicle(Vehicle car);
	void updateVehicle(Vehicle car);
	void delete(Vehicle car);


}
