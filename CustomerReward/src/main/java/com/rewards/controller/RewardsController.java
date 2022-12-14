package com.rewards.controller;

import com.rewards.model.TotalCustomerRewards;
import com.rewards.model.TotalCustomerTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rewards.entity.Customer;
import com.rewards.model.CustomerRewards;
import com.rewards.repository.CustomerRepository;
import com.rewards.service.CustomerRewardsService;

import java.util.List;

/**
 * Controller class for rewards
 * 
 * @author Damodar reddy
 *
 */

@RestController
@RequestMapping("/api/customers")
public class RewardsController {
	@Autowired
	CustomerRewardsService rewardsService;

	@Autowired
	CustomerRepository customerRepository;

	@GetMapping(value = "/rewards/{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerRewards> getRewardsBycustomerID(@PathVariable("customerID") int customerID) {
		Customer customer = customerRepository.findBycustomerID(customerID);
		if (customer == null) {
			throw new RuntimeException("Invalid Customer Id ");
		}
		CustomerRewards customerRewards = rewardsService.getRewardsBycustomerID(customerID);
		return new ResponseEntity<>(customerRewards, HttpStatus.OK);
	}
	@GetMapping(value = "/transactions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TotalCustomerTransactions>> getTransactions() {
		List<TotalCustomerTransactions> totalCustomerTransactionsList = rewardsService.getAllTransactions();
		return new ResponseEntity<>(totalCustomerTransactionsList, HttpStatus.OK);
	}
	@GetMapping(value = "/rewards", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TotalCustomerRewards>> getRewards() {
		List<TotalCustomerRewards> totalCustomerRewards = rewardsService.getAllRewards();
		return new ResponseEntity<>(totalCustomerRewards, HttpStatus.OK);
	}
}
