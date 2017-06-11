package com.pup.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pup.entity.Vehicle;
import com.pup.exception.NotFoundException;
import com.pup.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {


	@Autowired
	private VehicleRepository vrepo;

	@Override
	@Transactional(readOnly = true)
	public Vehicle findOne(String vinId) {
		Vehicle veh= vrepo.findOne(vinId);
		if(veh == null)
		{
			throw new NotFoundException("Car with Vin Number "+vinId+" does not exist!!");
		}
		return veh;

	}

	@Override
	@Transactional
	public void update(List<Vehicle> car)
	{

		for (Vehicle veh:car) 
		{
			Vehicle existingVin=vrepo.findOne(veh.getVin());
			if(existingVin == null)
			{
				vrepo.createVehicle(veh);
				
				System.out.println("service update success!!");
			}
			else
			{
				vrepo.updateVehicle(veh);
			}

		}
		
	}

	@Override
	@Transactional
	public void delete(String vinId) {

		Vehicle veh= vrepo.findOne(vinId);
		if(veh == null)
		{
			throw new NotFoundException("Car with Vin Number "+vinId+" does not exist!!");
		}
		vrepo.delete(veh);

	}

	@Override
	public List<Vehicle> findAll() {
		// TODO Auto-generated method stub
		return vrepo.findAll();
	}

}
