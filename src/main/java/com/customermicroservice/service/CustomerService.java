package com.customermicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customermicroservice.entity.Customer;
import com.customermicroservice.facade.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public Customer create(Customer cust) {
		return repository.insert(cust);
	}

	public Customer delete(int id) {
		Customer cust = findById(id);
		if (cust != null) {
			repository.delete(cust);
		}
		return cust;
	}

	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<Customer>();
		repository.findAll().forEach(customerList::add);
		return customerList;
	}

	public Customer findById(int id) {
		Optional<Customer> cust = repository.findById(id);
		return cust.get();
	}

	public Customer update(Customer cust) {
		return repository.save(cust);
	}

}
