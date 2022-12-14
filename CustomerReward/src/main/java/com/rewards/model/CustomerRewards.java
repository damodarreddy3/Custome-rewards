package com.rewards.model;

/**
 * Model Class for Customer rewards
 * 
 * @author Damodar reddy
 *
 */
public class CustomerRewards {

	private int customerID;
	private int lastMonthRewardPoints;
	private int lastSecondMonthRewardPoints;
	private int lastThirdMonthRewardPoints;
	private int totalRewards;

	public int getcustomerID() {
		return customerID;
	}

	public void setcustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getLastMonthRewardPoints() {
		return lastMonthRewardPoints;
	}

	public void setLastMonthRewardPoints(int lastMonthRewardPoints) {
		this.lastMonthRewardPoints = lastMonthRewardPoints;
	}

	public int getLastSecondMonthRewardPoints() {
		return lastSecondMonthRewardPoints;
	}

	public void setLastSecondMonthRewardPoints(int lastSecondMonthRewardPoints) {
		this.lastSecondMonthRewardPoints = lastSecondMonthRewardPoints;
	}

	public int getLastThirdMonthRewardPoints() {
		return lastThirdMonthRewardPoints;
	}

	public void setLastThirdMonthRewardPoints(int lastThirdMonthRewardPoints) {
		this.lastThirdMonthRewardPoints = lastThirdMonthRewardPoints;
	}

	public int getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(int totalRewards) {
		this.totalRewards = totalRewards;
	}

}
