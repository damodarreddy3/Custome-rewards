package com.rewards.entity;

import com.rewards.model.TotalCustomerTransactions;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for Transaction this is to understand
 * @author Damodar reddy
 *
 */

@Entity
@Table(name="TRANSACTION")
public class Transaction {
	
	 @Id
	    @GeneratedValue( strategy = GenerationType.IDENTITY)
	    @Column(name = "TRANSACTION_ID")
	    private Long transactionId;

	    @Column(name="CUSTOMER_ID")
	    private int customerID;

	    @Column(name = "TRANSACTION_DATE")
	    private Date transactionDate;

	    @Column(name = "AMOUNT")
	    private double transactionAmount;

	public Transaction(){

	}

	public Long getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(Long transactionId) {
			this.transactionId = transactionId;
		}

		public int getcustomerID() {
			return customerID;
		}

		public void setcustomerID(int customerID) {
			this.customerID = customerID;
		}

		public Date getTransactionDate() {
			return transactionDate;
		}

		public void setTransactionDate(Date transactionDate) {
			this.transactionDate = transactionDate;
		}

		public double getTransactionAmount() {
			return transactionAmount;
		}

		public void setTransactionAmount(double transactionAmount) {
			this.transactionAmount = transactionAmount;
		}
	    
	    
}
