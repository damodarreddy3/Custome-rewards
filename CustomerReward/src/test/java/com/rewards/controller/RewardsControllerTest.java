package com.rewards.controller;

import com.rewards.entity.Customer;
import com.rewards.model.CustomerRewards;
import com.rewards.model.TotalCustomerRewards;
import com.rewards.model.TotalCustomerTransactions;
import com.rewards.repository.CustomerRepository;
import com.rewards.service.CustomerRewardsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RewardsControllerTest {
    @InjectMocks
    private RewardsController rewardsController;

    @MockBean
    private CustomerRewardsServiceImpl customerRewardsService;

    @MockBean
    private CustomerRepository customerRepository;

    @Mock
    HttpHeaders httpHeaders;

    private Customer customer = new Customer();
    private CustomerRewards customerRewards = new CustomerRewards();
    private MockMvc mockMvc;
    private List<TotalCustomerTransactions> totalCustomerTransactionsList = new ArrayList<>();
    private List<TotalCustomerRewards> totalCustomerRewardsList = new ArrayList<>();
    private TotalCustomerRewards totalCustomerRewards = new TotalCustomerRewards();
    private TotalCustomerTransactions totalCustomerTransactions = new TotalCustomerTransactions();
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

      @Before
     public void init(){
          MockitoAnnotations.initMocks(this);
          customer.setCustomerID(1);
          customer.setCustomerName("Test Customer");
          customerRewards.setTotalRewards(30);
          customerRewards.setcustomerID(1);
          customerRewards.setLastMonthRewardPoints(10);
          customerRewards.setLastSecondMonthRewardPoints(15);
          customerRewards.setLastThirdMonthRewardPoints(5);
          mockMvc = MockMvcBuilders.standaloneSetup(rewardsController).build();
          totalCustomerTransactions.setcustomerID(1);
          totalCustomerTransactions.settotalTransactions(1234.0);
          totalCustomerTransactionsList.add(totalCustomerTransactions);
          totalCustomerRewards.setcustomerID(1);
          totalCustomerRewards.settotalRewards(20);
          totalCustomerRewardsList.add(totalCustomerRewards);
      }
    @Test
    public void testGetRewardsBycustomerID()
    {
        Mockito.when(customerRepository.findBycustomerID(1)).thenReturn(customer);
        Mockito.when(customerRewardsService.getRewardsBycustomerID(customer.getCustomerID())).thenReturn(customerRewards);
        CustomerRewards customerReward = rewardsController.getRewardsBycustomerID(1).getBody();
        Assert.assertNotNull(customerReward);
        Assert.assertEquals(customerReward.getTotalRewards(),30);
    }
//    @Test(expected = RuntimeException.class)
//    public void testNullGetRewardsBycustomerID()
//    {
//        Mockito.when(customerRepository.findBycustomerID(1)).thenReturn(new Customer());
//        Mockito.when(customerRewardsService.getRewardsBycustomerID(customer.getCustomerID())).thenReturn(customerRewards);
//        CustomerRewards customerRewards1 = rewardsController.getRewardsBycustomerID(1).getBody();
//    }
    @Test
    public void testGetTransactions(){
          Mockito.when(customerRewardsService.getAllTransactions()).thenReturn(totalCustomerTransactionsList);
           List<TotalCustomerTransactions> totalCustomerTransaction = rewardsController.getTransactions().getBody();
           Assert.assertNotNull(totalCustomerTransaction);
    }
    @Test
    public void testGetRewards(){
        Mockito.when(customerRewardsService.getAllRewards()).thenReturn(totalCustomerRewardsList);
        List<TotalCustomerRewards> totalCustomerReward = rewardsController.getRewards().getBody();
        Assert.assertNotNull(totalCustomerReward);
    }

}
