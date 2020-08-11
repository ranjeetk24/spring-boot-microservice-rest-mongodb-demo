package com.customermicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customermicroservice.entity.Customer;
import com.customermicroservice.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("cust")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<Customer> fildAll() {

		return customerService.findAll();
	}

	@PostMapping
	public Customer create(@RequestBody Customer cust) {
		return customerService.create(cust);
	}

	@PutMapping
	public Customer update(@RequestBody Customer cust) {
		return customerService.update(cust);
	}

	@DeleteMapping(path = { "/{id}" })
	public void delete(@PathVariable("id") int id) {
		customerService.delete(id);

	}

	@GetMapping(path = { "/{id}" })
	public Customer findUser(@PathVariable("id") int id) {
		return customerService.findById(id);
	}

}
