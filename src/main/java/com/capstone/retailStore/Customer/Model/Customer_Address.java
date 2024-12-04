package com.capstone.retailStore.Customer.Model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Customer_Address {
    int door_No;
    String streetName;
    String layOut;
    String city;
    String pincode;

}
