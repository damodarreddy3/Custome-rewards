package com.rewards.service;

import com.rewards.model.CustomerRewards;
import com.rewards.model.TotalCustomerRewards;
import com.rewards.model.TotalCustomerTransactions;

import java.util.List;

/**
 * Interface for customer rewards service
 * @author Damodar reddy
 *
 */
public interface CustomerRewardsService {
	public CustomerRewards getRewardsBycustomerID(int customerID);

	public List<TotalCustomerTransactions> getAllTransactions();

	public  List<TotalCustomerRewards> getAllRewards();
}
