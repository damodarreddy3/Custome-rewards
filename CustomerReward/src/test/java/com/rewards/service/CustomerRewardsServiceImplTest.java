package com.rewards.service;

import com.rewards.entity.Customer;
import com.rewards.entity.Transaction;
import com.rewards.model.CustomerRewards;
import com.rewards.model.TotalCustomerTransactions;
import com.rewards.repository.CustomerRepository;
import com.rewards.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerRewardsServiceImplTest {
    @InjectMocks
    CustomerRewardsServiceImpl customerRewardsService;
    @MockBean
    TransactionRepository transactionRepository;
    @MockBean
    CustomerRepository customerRepository;
    @Mock
    HttpHeaders httpHeaders;

    private Transaction transaction = new Transaction();
    private List<Transaction> transactionList = new ArrayList<>();
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        transaction.setTransactionAmount(20);
        transaction.setcustomerID(1);
        transaction.setTransactionId(123L);
        transactionList.add(transaction);
    }
    @Test
    public void testGetRewardsBycustomerID(){
        Timestamp fromTs = Timestamp.from(Instant.now());
        Mockito.when(transactionRepository.findAllByCustomerIDAndTransactionDateBetween(1, fromTs, fromTs)).thenReturn(transactionList);
        CustomerRewards customerReward = customerRewardsService.getRewardsBycustomerID(1);
        Assert.assertNotNull(customerReward);
        Assert.assertEquals(customerReward.getTotalRewards(),0);

    }
    @Test
    public void testGetAllTransactions(){
    Mockito.when(transactionRepository.findAll()).thenReturn(transactionList);
        List<TotalCustomerTransactions> totalCustomerTransaction = customerRewardsService.getAllTransactions();
        Assert.assertNotNull(totalCustomerTransaction);
    }
}
