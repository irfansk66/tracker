package com.pup.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pup.entity.Vehicle;
import com.pup.service.VehicleService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class VehicleController {
	
	@Autowired
	private VehicleService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{id}",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vehicle findOne(@PathVariable("id") String vinId)
	{
		
		return service.findOne(vinId);
		
	} 	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/vehicles",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vehicle> findAll()
	{
		
		return service.findAll();
		
	} 
	
	
	
	

	@RequestMapping(method=RequestMethod.PUT, value="/vehicles",
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void update(@RequestBody List<Vehicle> cars)
	{
		service.update(cars);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/vehicles/{id}")
	public void delete(@PathVariable("id") String vinId)
	{
		service.delete(vinId);
	}
	
	

}
