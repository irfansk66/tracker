package com.pup.service;

import java.util.List;

import com.pup.entity.Alert;
import com.pup.entity.HighAlert;

public interface AlertService {

	List<Alert> findAll();
	List<Alert> findAllHistoricalAlertsOfVehicle(String vin);
}
