package com.pup.repository;

import java.util.List;

import com.pup.entity.Readings;

import com.pup.entity.Vehicle;

public interface ReadingsRepository {

	
	void create(Readings carreadings);

	List<Readings> geolocations(String VinId);
	Vehicle findveh(String vinNo);
	List<Readings> getPlotSignalReadings(String VinId, float range);
}
