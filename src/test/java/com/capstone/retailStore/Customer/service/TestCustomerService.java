package com.capstone.retailStore.Customer.service;

import com.capstone.retailStore.Customer.Model.Customer;
import com.capstone.retailStore.Customer.repository.CustomerRepository;
import com.capstone.retailStore.Customer.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestCustomerService {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private CustomerService service;



   @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setCustomer_Id(1);
        customer.setCustomerName("Anil");
        when(customerRepository.save(any())).thenReturn(customer);
       Customer customer1 = service.saveCustomer(customer);
//        assertEquals(customer.getCustomer_Id(),1);
//        assertEquals(customer.getCustomerName(),"Anil");
       verify(customerRepository, times(1)).save(any());
   }
   @Test
   public void testDeleteByCustomerId() {
       when(customerRepository.existsById(any())).thenReturn(true);
       boolean b = service.deleteByCustomerId(1);
       assertTrue(b);
   }
   @Test
   public void testFindByCustomerById() {
       Customer customer = new Customer();
       customer.setCustomer_Id(1);
       customer.setCustomerName("Anil");
       when(customerRepository.findById(any())).thenReturn(Optional.of(customer));
       Customer  customer1 = service.findByCustomerById(1);
     assertEquals(customer1.getCustomer_Id(),customer.getCustomer_Id());
     assertEquals(customer1.getCustomerName(),customer.getCustomerName());
   }
   @Test
   public void testFindBycustomerName() {
       Customer customer = new Customer();
       customer.setCustomer_Id(1);
       customer.setCustomerName("Anil");
       List<Customer> customerList = new ArrayList<>();
       customerList.add(customer);
       when(customerRepository.findBycustomerName(any())).thenReturn(customerList);
      List<Customer>   customers = service.findBycustomerName("Anil");
     assertEquals(customers.size(),1);

   }

}
