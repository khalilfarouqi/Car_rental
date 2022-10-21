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
		return serviceCarImpl.getAll();
	}
	
	@GetMapping("/GetCar/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable("id") Long ID){
		return new ResponseEntity<Car>(serviceCarImpl.getById(ID), HttpStatus.OK);
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
	
	@PostMapping("/SaveOrder")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(serviceOrderImpl.save(order), HttpStatus.CREATED);
	}
	
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
