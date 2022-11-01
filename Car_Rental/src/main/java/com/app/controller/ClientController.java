package com.app.controller;

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.app.entity.*;
import com.app.sevice.impl.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/Client") 
public class ClientController {
	
	private ServiceCarImpl serviceCarImpl;
	private ServiceClientImpl serviceClientImpl;
	private ServiceOrderImpl serviceOrderImpl;
	
	public ClientController(ServiceCarImpl serviceCarImpl, ServiceClientImpl serviceClientImpl,
			ServiceOrderImpl serviceOrderImpl) {
		super();
		this.serviceCarImpl = serviceCarImpl;
		this.serviceClientImpl = serviceClientImpl;
		this.serviceOrderImpl = serviceOrderImpl;
	}
	
	
//	-------------------------------------------Car-------------------------------------------
	
	@GetMapping("/ListCar")
	public List<Car> getAllCar(){
		try {
			return serviceCarImpl.getAll();
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	@GetMapping("/GetCar/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long ID){
		try {
			return new ResponseEntity<Car>(serviceCarImpl.getById(ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
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
			throw new RuntimeException(e);
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
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable("id") Long ID,@RequestBody Client client){
		try {
			return new ResponseEntity<Client>(serviceClientImpl.update(client, ID), HttpStatus.OK);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> deleteClientById(@PathVariable("id") Long ID){
		try {
			serviceClientImpl.deleteById(ID);
			return new ResponseEntity<String>("Client deleted successfully!.", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
	
	@PostMapping("/SaveOrder")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		try {
			return new ResponseEntity<Order>(serviceOrderImpl.save(order), HttpStatus.CREATED);
		}catch (Exception e){
			System.out.println(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
		}catch (Exception e){
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
}
