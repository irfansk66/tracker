package com.pup.service;


import java.util.List;

import com.pup.entity.Vehicle;

public interface VehicleService {

	
	Vehicle findOne(String vinId);
	void update(List<Vehicle> cars);
	void delete(String vinId);


	
}
