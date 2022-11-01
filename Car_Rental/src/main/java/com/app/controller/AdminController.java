package com.app.controller;

import java.util.List;
import java.util.function.DoubleToIntFunction;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.entity.*;
import com.app.sevice.impl.*;

@RestController
@RequestMapping(value = "/Admin") 
public class AdminController {
	
	private ServiceCarImpl serviceCarImpl;
	private ServiceUserImpl serviceUserImpl;
	private ServiceClientImpl serviceClientImpl;
	private ServiceOrderImpl serviceOrderImpl;
	private ServicePhotoImpl servicePhotoImpl;
	
	public AdminController(ServiceCarImpl serviceCarImpl, ServiceUserImpl serviceUserImpl, ServiceClientImpl serviceClientImpl,
			ServiceOrderImpl serviceOrderImpl, ServicePhotoImpl servicePhotoImpl) {
		super();
		this.serviceCarImpl = serviceCarImpl;
		this.serviceUserImpl = serviceUserImpl;
		this.serviceClientImpl = serviceClientImpl;
		this.serviceOrderImpl = serviceOrderImpl;
		this.servicePhotoImpl = servicePhotoImpl;
	}
	
//	-------------------------------------------Car-------------------------------------------

	@GetMapping("/ListCar")
	public List<Car> getAllCar(){
		return serviceCarImpl.getAll();
	}
	
	@PostMapping("/SaveCar")
	public ResponseEntity<Car> saveCar(@RequestBody @NotNull Car car){
		return new ResponseEntity<Car>(serviceCarImpl.save(car), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetCar/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<Car>(serviceCarImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/UpdateCar/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") Long ID,@RequestBody @NotNull Car car){
		try {
			serviceCarImpl.update(car, ID);
			return new ResponseEntity<>(serviceCarImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeleteCar/{id}")
	public ResponseEntity<String> deleteCarById(@PathVariable("id") Long ID){
		try {
			serviceCarImpl.deleteById(ID);
			return new ResponseEntity<String>("Car deleted successfully!.", HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	-------------------------------------------User-------------------------------------------
	
	@GetMapping("/ListUser")
	public List<User> getAllUser(){
		return serviceUserImpl.getAll();
	}
	
	@PostMapping("/SaveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<User>(serviceUserImpl.save(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<User>(serviceUserImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/UpdateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long ID,@RequestBody User user){
		try {
			serviceUserImpl.update(user, ID);
			return new ResponseEntity<>(serviceUserImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long ID){
		try {
			serviceUserImpl.deleteById(ID);
			return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	-------------------------------------------Client-------------------------------------------
	
	@GetMapping("/ListClient")
	public List<Client> getAllClient(){
		try {
			return serviceClientImpl.getAll();
		}catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("/SaveClient")
	public ResponseEntity<Client> saveClient(@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(serviceClientImpl.save(client), HttpStatus.CREATED);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/GetClient/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<Client>(serviceClientImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long ID,@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(serviceClientImpl.update(client, ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> deleteClientById(@PathVariable("id") Long ID){
		try {
			serviceClientImpl.deleteById(ID);
			return new ResponseEntity<String>("Client deleted successfully!.", HttpStatus.OK);
		}catch (Exception e){
			System.out.println("--------> " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
//	-------------------------------------------Order-------------------------------------------
	
	@GetMapping("/ListOrder")
	public List<Order> getAllOrder(){
		try {
			return serviceOrderImpl.getAll();
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
//	@PostMapping("/SaveOrder")
//	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
//		return new ResponseEntity<Order>(serviceOrderImpl.save(order), HttpStatus.CREATED);
//	}
	
	@GetMapping("/GetOrder/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<Order>(serviceOrderImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/UpdateOrder/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long ID,@RequestBody Order order){
		try {
			return new ResponseEntity<Order>(serviceOrderImpl.update(order, ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeleteOrder/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") Long ID){
		try {
			serviceOrderImpl.deleteById(ID);
			return new ResponseEntity<String>("Order deleted successfully!.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	-------------------------------------------Photo-------------------------------------------
	
	@GetMapping("/ListPhoto")
	public List<Photo> getAllPhoto(){
		try {
			return servicePhotoImpl.getAll();
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/SavePhoto")
	public ResponseEntity<Photo> savePhoto(@RequestBody Photo photo){
		try {
			return new ResponseEntity<Photo>(servicePhotoImpl.save(photo), HttpStatus.CREATED);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/GetPhoto/{id}")
	public ResponseEntity<Photo> getPhotoById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<Photo>(servicePhotoImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/UpdatePhoto/{id}")
	public ResponseEntity<Photo> updatePhoto(@PathVariable("id") Long ID,@RequestBody Photo photo){
		try {
			return new ResponseEntity<Photo>(servicePhotoImpl.update(photo, ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeletePhoto/{id}")
	public ResponseEntity<String> deletePhotoById(@PathVariable("id") Long ID){
		try {
			servicePhotoImpl.deleteById(ID);
			return new ResponseEntity<String>("Photo deleted successfully!.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
