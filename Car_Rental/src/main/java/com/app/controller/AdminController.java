package com.app.controller;

import java.util.List;

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
	
	public AdminController(ServiceCarImpl serviceCarImpl, ServiceUserImpl serviceUserImpl, ServiceClientImpl serviceClientImpl,
			ServiceOrderImpl serviceOrderImpl) {
		super();
		this.serviceCarImpl = serviceCarImpl;
		this.serviceUserImpl = serviceUserImpl;
		this.serviceClientImpl = serviceClientImpl;
		this.serviceOrderImpl = serviceOrderImpl;
	}
	
//	-------------------------------------------Car-------------------------------------------

	@GetMapping("/ListCar")
	public List<Car> getAllCar(){
		return serviceCarImpl.getAll();
	}
	
	@PostMapping("/SaveCar")
	public ResponseEntity<Car> saveCar(@RequestBody Car car){
		return new ResponseEntity<Car>(serviceCarImpl.save(car), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetCar/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long ID){
		return new ResponseEntity<Car>(serviceCarImpl.getById(ID), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateCar/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable("id") Long ID,@RequestBody Car car){
		return new ResponseEntity<Car>(serviceCarImpl.update(car, ID), HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteCar/{id}")
	public ResponseEntity<String> deleteCarById(@PathVariable("id") Long ID){
		serviceCarImpl.deleteById(ID);
		return new ResponseEntity<String>("Car deleted successfully!.", HttpStatus.OK);
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
		return new ResponseEntity<User>(serviceUserImpl.getById(ID), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateUser/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long ID,@RequestBody User user){
		return new ResponseEntity<User>(serviceUserImpl.update(user, ID), HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteUser/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable("id") Long ID){
		serviceUserImpl.deleteById(ID);
		return new ResponseEntity<String>("User deleted successfully!.", HttpStatus.OK);
	}
	
//	-------------------------------------------Client-------------------------------------------
	
	@GetMapping("/ListClient")
	public List<Client> getAllClient(){
		return serviceClientImpl.getAll();
	}
	
	@PostMapping("/SaveClient")
	public ResponseEntity<Client> saveClient(@RequestBody Client client){
		return new ResponseEntity<Client>(serviceClientImpl.save(client), HttpStatus.CREATED);
	}
	
	@GetMapping("/GetClient/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") Long ID){
		return new ResponseEntity<Client>(serviceClientImpl.getById(ID), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long ID,@RequestBody Client client){
		return new ResponseEntity<Client>(serviceClientImpl.update(client, ID), HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> deleteClientById(@PathVariable("id") Long ID){
		serviceClientImpl.deleteById(ID);
		return new ResponseEntity<String>("Client deleted successfully!.", HttpStatus.OK);
	}
//	-------------------------------------------Order-------------------------------------------
	
	@GetMapping("/ListOrder")
	public List<Order> getAllOrder(){
		return serviceOrderImpl.getAll();
	}
	
//	@PostMapping("/SaveOrder")
//	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
//		return new ResponseEntity<Order>(serviceOrderImpl.save(order), HttpStatus.CREATED);
//	}
	
	@GetMapping("/GetOrder/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long ID){
		return new ResponseEntity<Order>(serviceOrderImpl.getById(ID), HttpStatus.OK);
	}
	
	@PutMapping("/UpdateOrder/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long ID,@RequestBody Order order){
		return new ResponseEntity<Order>(serviceOrderImpl.update(order, ID), HttpStatus.OK);
	}
	
	@DeleteMapping("/DeleteOrder/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable("id") Long ID){
		serviceOrderImpl.deleteById(ID);
		return new ResponseEntity<String>("Order deleted successfully!.", HttpStatus.OK);
	}
	
	
	
}
