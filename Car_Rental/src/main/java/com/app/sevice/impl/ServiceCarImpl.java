package com.app.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Car;
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
		return null;
		/*Car existingCar = carRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("photoRepository", "Id", id));
		
		existingCar.setAirConditione(car.getAirConditione());
		existingCar.setBluetooth(car.getBluetooth());
		existingCar.setBrand(car.getBrand());
		existingCar.setColor(car.getColor());
		existingCar.setDescription(car.getDescription());
		existingCar.setDoors(car.getDoors());
		existingCar.setFuel(car.getFuel());
		existingCar.setFuelConsomation(car.getFuelConsomation());
		existingCar.setGearbox(car.getGearbox());
		existingCar.setName(car.getName());
		existingCar.setPhoto(car.getPhoto());
		existingCar.setPower(car.getPower());
		existingCar.setPrix(car.getPrix());
		existingCar.setReservation(car.getReservation());
		existingCar.setSeats(car.getSeats());

		carRepo.save(existingCar);

		return existingCar;*/
	}

	@Override
	public void deleteById(Long id) {
		this.carRepo.deleteById(id);
	}

}
