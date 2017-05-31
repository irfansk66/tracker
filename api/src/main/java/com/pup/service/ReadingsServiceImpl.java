package com.pup.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.entity.Alert;
import com.pup.entity.Readings;
import com.pup.entity.Vehicle;
import com.pup.exception.NotFoundException;
import com.pup.repository.AlertRepository;
import com.pup.repository.ReadingsRepository;

@Service
public class ReadingsServiceImpl implements ReadingsService {
	
	
	
	@Autowired
	private ReadingsRepository Rrepo;
	
	@Autowired
	private AlertRepository Arepo;

	@Override
	@Transactional
	public void create(Readings carreadings) {
		// TODO Auto-generated method stub
		
		Vehicle  veh = Rrepo.findveh(carreadings.getVin());
		if(veh == null)
		{
			throw new NotFoundException("Car with Vin Number "+carreadings.getVin()+" does not exist in Vehicle table!!");
		}
		else
		{
			if(carreadings.isEngineCoolantLow() || carreadings.isCheckEngineLighton())
			{
				Alert coolant = new Alert();
				coolant.setVin(carreadings.getVin());
				coolant.setTimestamp(carreadings.getTimestamp());
				coolant.setMessage("Engine coolant is low or Check engine light is on");
				coolant.setPriority("LOW");
				Arepo.coolantAlert(coolant);
			}
			if(carreadings.getSpeed()>100)
			{
				Alert speed = new Alert();
				speed.setVin(carreadings.getVin());
				speed.setTimestamp(carreadings.getTimestamp());
				speed.setMessage("Car is moving at a speed of over 100 miles per hour");
				speed.setPriority("MEDIUM");
				Arepo.speedAlert(speed);
				
			}
			if(carreadings.getFuelVolume()<(float)veh.getMaxFuelVolume()*(0.1))
			{
				Alert fuelVol = new Alert();
				fuelVol.setVin(carreadings.getVin());
				fuelVol.setTimestamp(carreadings.getTimestamp());
				fuelVol.setMessage("Fuel Volume is less than 10%");
				fuelVol.setPriority("MEDIUM");
				Arepo.fuelVolumeAlert(fuelVol);
				
			}
			
			if(carreadings.getEngineRpm()>veh.getRedlineRpm())
			{
				Alert engineRpm = new Alert();
				engineRpm.setVin(carreadings.getVin());
				engineRpm.setTimestamp(carreadings.getTimestamp());
				engineRpm.setMessage("Car has crossed the RED LINE RPM Limit");
				engineRpm.setPriority("High");
				Arepo.rpmAlert(engineRpm);
				
			}
			if((carreadings.getTires().getFrontLeft()<32 || carreadings.getTires().getFrontLeft()>36) ||
					(carreadings.getTires().getFrontRight()<32 || carreadings.getTires().getFrontRight()>36) ||
					(carreadings.getTires().getRearLeft()<32 || carreadings.getTires().getRearLeft()>36) ||
					(carreadings.getTires().getRearRight()<32 ||carreadings.getTires().getRearRight()>36))
			{
				Alert tires = new Alert();
				tires.setVin(carreadings.getVin());
				tires.setTimestamp(carreadings.getTimestamp());
				tires.setMessage("Tire pressure is not correct");
				tires.setPriority("LOW");
				Arepo.tireAlert(tires);
				
			}
			
			Rrepo.create(carreadings);
		}
				
		
	}

}
