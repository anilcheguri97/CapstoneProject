package com.capstone.retailStore.Customer.repository;

import com.capstone.retailStore.Customer.Model.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;
    Customer customer = new Customer();
    @BeforeEach
    public void setUp() {
        // Initialize test data before each test method

        customer.setCustomerName("Anil");
        customer.setCustomer_Id(1);
        customerRepository.save(customer);
    }

    @AfterEach
    public void tearDown() {
        // Release test data after each test method
        customerRepository.delete(customer);
    }
    @Test
    public void testFindBycustomerName() {

        List<Customer> customerList = customerRepository.findBycustomerName("Anil");
        assertEquals(1,customerList.size());
    }


}
