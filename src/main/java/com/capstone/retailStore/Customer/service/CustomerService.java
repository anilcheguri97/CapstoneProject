package com.capstone.retailStore.Customer.service;

import com.capstone.retailStore.Customer.Model.Customer;
import com.capstone.retailStore.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {

        return  customerRepository.save(customer);
    }
    public boolean deleteByCustomerId(Integer  customerId) {
        if(customerRepository.existsById(customerId) ) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return  false;
    }

    public Customer findByCustomerById(Integer id) {
        return customerRepository.findById(id).get();
    }
    public List<Customer> findBycustomerName(String name){
        return customerRepository.findBycustomerName(name);
    }
}
