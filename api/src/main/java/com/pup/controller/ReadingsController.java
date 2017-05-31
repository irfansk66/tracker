package com.pup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pup.entity.Readings;
import com.pup.service.ReadingsService;


@RestController
@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
public class ReadingsController {
	
	@Autowired
	private ReadingsService readservice;
	
	@RequestMapping(method=RequestMethod.POST, value="/readings",
			produces=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE,
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void create(@RequestBody Readings carreadings)
	{
		
		System.out.println(carreadings.toString());
		 readservice.create(carreadings);
		
		
	}

}
