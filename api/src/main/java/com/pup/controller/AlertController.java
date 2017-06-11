package com.pup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pup.entity.Alert;
import com.pup.entity.HighAlert;
import com.pup.service.AlertService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AlertController {
	
	
	@Autowired
	private AlertService aservice;
	
	@RequestMapping(method=RequestMethod.GET, value="/alerts",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findAll()
	{
		
		return aservice.findAll();
		
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/alerts/{id}",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Alert> findAllHistoricalAlertsOfVehicle(@PathVariable("id") String vin)
	{
		
		return aservice.findAllHistoricalAlertsOfVehicle(vin);
		
	} 
	

}
