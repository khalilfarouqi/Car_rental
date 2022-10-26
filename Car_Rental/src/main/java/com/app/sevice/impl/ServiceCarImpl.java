package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CarRepo;
import com.app.sevice.IService;

@Service
public class ServiceCarImpl implements IService<Car> {
	
	@Autowired
	private CarRepo carRepo;

	@Override
	public List<Car> getAll() {
		return carRepo.findAll();
	}

	@Override
	public Car save(Car car) {
		return carRepo.save(car);
	}

	@Override
	public Car getById(Long id) {
		return carRepo.findById(id).get();
	}

	@Override
	public Car update(Car car, Long id) {
		//return null;
		Car existingCar = carRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("photoRepository", "Id", id));
		
		existingCar.setAirBag(car.getAirBag());
		existingCar.setBluetooth(car.getBluetooth());
		existingCar.setBrande(car.getBrande());
		existingCar.setBris_Glace_Pneus(car.getBris_Glace_Pneus());
		existingCar.setCDM(car.getCDM());
		existingCar.setConsumption(car.getConsumption());
		existingCar.setFuel(car.getFuel());
		existingCar.setGearBox(car.getGearBox());
		existingCar.setHorsPower(car.getHorsPower());
		existingCar.setMileage(car.getMileage());
		existingCar.setModel(car.getModel());
		existingCar.setMatricule(car.getMatricule());
		existingCar.setName(car.getName());
		existingCar.setOrders(car.getOrders());
		existingCar.setPhoto(car.getPhoto());
		existingCar.setPrice(car.getPrice());
		existingCar.setProtection_Vol(car.getProtection_Vol());
		existingCar.setRate(car.getRate());
		existingCar.setRespo_Civile(car.getRespo_Civile());
		existingCar.setSeat(car.getSeat());
		existingCar.setSize_Cofer(car.getSize_Cofer());
		existingCar.setStyle(car.getStyle());

		carRepo.save(existingCar);

		return existingCar;/**/
	}

	@Override
	public void deleteById(Long id) {
		this.carRepo.deleteById(id);
	}

}
