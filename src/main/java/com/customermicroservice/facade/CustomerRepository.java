package com.customermicroservice.facade;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.customermicroservice.entity.Customer;



@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer>{

}
