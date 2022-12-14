package com.rewards.model;

/**
 * Model Class for Customer rewards
 * 
 * @author Damodar reddy
 *
 */
public class TotalCustomerRewards {

	private Integer customerID;
	private int totalRewards;

	public Integer getcustomerID() {
		return customerID;
	}

	public void setcustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public int gettotalRewards() {
		return totalRewards;
	}

	public void settotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}

}
