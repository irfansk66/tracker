package com.pup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.entity.Alert;
import com.pup.entity.HighAlert;
import com.pup.repository.AlertRepository;


@Service
public class AlertServiceImpl implements AlertService{
	
	@Autowired
	private AlertRepository arepo;

	@Override
	public List<Alert> findAll() {
		// TODO Auto-generated method stub
		
		return arepo.findAll();
	}

	@Override
	public List<Alert> findAllHistoricalAlertsOfVehicle(String vin) {
		// TODO Auto-generated method stub
		return arepo.findAllHistoricalAlertsOfVehicle(vin);
	}

}
