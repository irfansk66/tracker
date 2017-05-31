package com.pup.repository;

import com.pup.entity.Readings;

import com.pup.entity.Vehicle;

public interface ReadingsRepository {

	
	void create(Readings carreadings);

	
	Vehicle findveh(String vinNo);
}
