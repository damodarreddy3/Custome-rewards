package com.rewards.model;

/**
 * Model Class for Customer rewards
 * 
 * @author Damodar reddy
 *
 */
public class TotalCustomerTransactions {

	private Integer customerID;
	private Double totalTransactions;

	public TotalCustomerTransactions(Integer customerID, Double totalTransactions) {
		this.totalTransactions = totalTransactions;
		this.customerID = customerID;
	}

	public TotalCustomerTransactions() {

	}

	public Integer getcustomerID() {
		return customerID;
	}

	public void setcustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Double gettotalTransactions() {
		return totalTransactions;
	}

	public void settotalTransactions(Double totalTransactions) {
		this.totalTransactions = totalTransactions;
	}

}
