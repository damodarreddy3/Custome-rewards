package com.rewards.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rewards.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	public List<Transaction> findAllBycustomerID(int customerID);

	public List<Transaction> findAllByCustomerIDAndTransactionDateBetween(int customerID, Timestamp fromTs, Timestamp toTs);

	public List<Transaction> findAll();
}
