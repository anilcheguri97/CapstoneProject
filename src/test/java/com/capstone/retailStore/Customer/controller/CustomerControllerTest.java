package com.capstone.retailStore.Customer.controller;

import com.capstone.retailStore.Customer.Model.Customer;
import com.capstone.retailStore.Customer.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @Test
    public void HelloWorld() throws  Exception {
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/api/hello").accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("WelCome to Controller",mvcResult.getResponse().getContentAsString());

    }
    @Test
    public void testAddCustomer() throws Exception {
        String uri = "/api/addCustomer";
        Customer customer = new Customer();
        customer.setCustomer_Id(1);
        customer.setCustomerName("Anil");

        String json = this.convertToJson( customer);
       when(service.saveCustomer(any())).thenReturn(customer);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(json)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201,status);
    }
    @Test
    public void testDeleteById() throws Exception {
        String uri = "/api/addCustomer";
        Customer customer = new Customer();
        customer.setCustomer_Id(1);
        customer.setCustomerName("Anil");
        when(service.deleteByCustomerId(any())).thenReturn(true);
        RequestBuilder builder = MockMvcRequestBuilders.delete("/api/delete/id/{id}",1).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = (MvcResult) mockMvc.perform(builder).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(),200);
    }

    @Test
    public void testSearchCustomerById() throws Exception {
        Customer customer = new Customer();
        customer.setCustomer_Id(1);
        customer.setCustomerName("Anil");
        when(service.findByCustomerById(any())).thenReturn(customer);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/customer/{id}",1).accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult =  mockMvc.perform(requestBuilder).andReturn();
        assertEquals(mvcResult.getResponse().getStatus(),302);
        assertEquals(customer.getCustomer_Id(),1);
    }
    private String convertToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);

    }
}
