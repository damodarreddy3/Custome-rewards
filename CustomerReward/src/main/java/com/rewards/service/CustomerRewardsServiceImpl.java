package com.rewards.service;

import java.security.Key;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.rewards.entity.Customer;
import com.rewards.model.TotalCustomerRewards;
import com.rewards.model.TotalCustomerTransactions;
import com.rewards.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.rewards.entity.Transaction;
import com.rewards.model.CustomerRewards;
import com.rewards.repository.TransactionRepository;
import org.springframework.stereotype.Service;

/**
 * Implementation class for customer rewards
 * 
 * @author Damodar reddy
 *
 */
@Service
public class CustomerRewardsServiceImpl implements CustomerRewardsService {

	public static final int daysInMonths = 30;
	public static int firstRewardLimit = 50;
	public static int secondRewardLimit = 100;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	CustomerRepository customerRepository;

	public CustomerRewards getRewardsBycustomerID(int customerID) {
		Timestamp lastMonthTimestamp = getDateBasedOnOffSetDays(daysInMonths);
		Timestamp lastSecondMonthTimestamp = getDateBasedOnOffSetDays(2 * daysInMonths);
		Timestamp lastThirdMonthTimestamp = getDateBasedOnOffSetDays(3 * daysInMonths);

		List<Transaction> lastMonthTransactions = transactionRepository
				.findAllByCustomerIDAndTransactionDateBetween(customerID, lastMonthTimestamp, Timestamp.from(Instant.now()));
		List<Transaction> lastSecondMonthTransactions = transactionRepository
				.findAllByCustomerIDAndTransactionDateBetween(customerID, lastSecondMonthTimestamp, lastMonthTimestamp);
		List<Transaction> lastThirdMonthTransactions = transactionRepository
				.findAllByCustomerIDAndTransactionDateBetween(customerID, lastThirdMonthTimestamp, lastSecondMonthTimestamp);

		int lastMonthRewardPoints = getRewardsPerMonth(lastMonthTransactions);
		int lastSecondMonthRewardPoints = getRewardsPerMonth(lastSecondMonthTransactions);
		int lastThirdMonthRewardPoints = getRewardsPerMonth(lastThirdMonthTransactions);

		CustomerRewards customerRewards = new CustomerRewards();
		customerRewards.setcustomerID(customerID);
		customerRewards.setLastMonthRewardPoints(lastMonthRewardPoints);
		customerRewards.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
		customerRewards.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
		customerRewards
				.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

		return customerRewards;

	}

	private int getRewardsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewards(transaction))
				.collect(Collectors.summingInt(r -> r.intValue()));
	}

	private int calculateRewards(Transaction transaction) {
		if (transaction.getTransactionAmount() > firstRewardLimit
				&& transaction.getTransactionAmount() <= secondRewardLimit) {
			return (int) Math.round(transaction.getTransactionAmount() - firstRewardLimit);
		} else if (transaction.getTransactionAmount() > secondRewardLimit) {
			return (int) Math.round(transaction.getTransactionAmount() - secondRewardLimit) * 2
					+ (secondRewardLimit - firstRewardLimit);
		} else
			return 01;

	}

	public List<TotalCustomerTransactions> getAllTransactions(){
		List<TotalCustomerTransactions> totalCustomerTransactionsList;
		List<Transaction> transactionList = transactionRepository
				.findAll();
		Map<Integer, Double> rewardsMap = new HashMap<>();
		transactionList.stream().collect(Collectors.groupingBy(Transaction::getcustomerID,Collectors.groupingBy(Transaction::getTransactionAmount)));
		rewardsMap = transactionList.stream().collect(Collectors.groupingBy(Transaction::getcustomerID,Collectors.summingDouble(Transaction::getTransactionAmount)));
		totalCustomerTransactionsList = rewardsMap.entrySet()
				.stream()
				.map(e -> {
					return new TotalCustomerTransactions(e.getKey(), e.getValue());
				})
				.collect(Collectors.toList());
		return totalCustomerTransactionsList;
	}

	public Timestamp getDateBasedOnOffSetDays(int days) {
		return Timestamp.valueOf(LocalDateTime.now().minusDays(days));
	}
	public List<TotalCustomerRewards> getAllRewards(){
		List<TotalCustomerTransactions> totalCustomerTransactionsList = getAllTransactions();
		List<Transaction> transactions = new ArrayList<>();
		List<TotalCustomerRewards> totalCustomerRewardsArrayList = new ArrayList<>();

		for(TotalCustomerTransactions totalCustomerTransactions : totalCustomerTransactionsList){
			Transaction transaction = new Transaction();
			transaction.setcustomerID(totalCustomerTransactions.getcustomerID());
			transaction.setTransactionAmount(totalCustomerTransactions.gettotalTransactions());
			transactions.add(transaction);
		}
		for(Transaction tran : transactions){
			TotalCustomerRewards totalCustomerRewards = new TotalCustomerRewards();
			totalCustomerRewards.setcustomerID(tran.getcustomerID());
			totalCustomerRewards.settotalRewards(calculateRewards(tran));
			totalCustomerRewardsArrayList.add(totalCustomerRewards);
		}
		return totalCustomerRewardsArrayList;
	}

}
