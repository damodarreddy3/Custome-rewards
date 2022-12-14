package com.rewards.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rewards.entity.Customer;

import java.util.List;

/**
 * Repository class for Customer
 * @author Damodar reddy
 *
 */

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	public Customer findBycustomerID(int id);

	public List<Customer> findAll();
	
	

}
