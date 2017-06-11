package com.pup.service;

import java.util.List;

import com.pup.entity.Readings;

public interface ReadingsService {
	
	void create(Readings carreadings);
	List<Readings> geolocations(String VinId);
	List<Readings> getPlotSignalReadings(String VinId, float range);

}
