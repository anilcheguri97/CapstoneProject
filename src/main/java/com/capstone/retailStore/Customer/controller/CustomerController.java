package com.capstone.retailStore.Customer.controller;

import com.capstone.retailStore.Customer.Exception.CustomerNotFoundException;
import com.capstone.retailStore.Customer.Exception.InputException;
import com.capstone.retailStore.Customer.Exception.ResourceNotFoundException;
import com.capstone.retailStore.Customer.Model.Customer;
import com.capstone.retailStore.Customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RefreshScope
@RestController
@RequestMapping("/customer")
@EnableMethodSecurity
public class CustomerController {
    private static  final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    CustomerService customerService;
    @Value("${message}")
    String message;

    @GetMapping("/welcome")
    public String welcome() {
        return message;
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/hello")
    public String hello() {
        return "hello  to Controller";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "WelCome to admin Controller";
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        Customer customer1 = customerService.saveCustomer(customer);
        LOGGER.info("customer  is created in controller  in info");
        LOGGER.debug("customer  is created in controller in debug");
        LOGGER.warn("controller advice  is created for Exception in warn");

        if (customer1 == null) {

            LOGGER.error("controller advice  is created for Exception in error");
           throw  new CustomerNotFoundException(" cutomer not found");
        }
        return new ResponseEntity<>(customer1 , HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable(name = "id", required = false) Integer customerid) {
        LOGGER.info("customer  is created in controller  in info");
        LOGGER.debug("customer  is created in controller in debug");
        LOGGER.warn("controller advice  is created for Exception in warn");
        if(customerid==null){
            throw new InputException("u have entered null value pls enter valid value");
        }
        else {
            boolean isDeleted = customerService.deleteByCustomerId(customerid);
            if (isDeleted) {

                return new ResponseEntity<>("Customer row is deleted", HttpStatus.OK);
            }
            else
                throw new ResourceNotFoundException("Customer not found");
        }
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer id){

       Customer customer=  customerService.findByCustomerById(id);
        LOGGER.info("customer  is found info");
        LOGGER.debug("customer  is found debug");
       if(customer == null )
           throw new ResourceNotFoundException("Customer not found");
       return new ResponseEntity<>(customer,HttpStatus.FOUND);
    }


    @GetMapping("/customer/name/{name}")
    public ResponseEntity<List<Customer>> searchCustomerById(@PathVariable String name){
       List<Customer>  customers =  customerService.findBycustomerName(name);
        if(!customers.isEmpty())
        return new ResponseEntity<>(customers,HttpStatus.FOUND);
        else {
            throw new ResourceNotFoundException("Customer not found");
        }
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.saveCustomer(customer);

        return  new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }


    


}
