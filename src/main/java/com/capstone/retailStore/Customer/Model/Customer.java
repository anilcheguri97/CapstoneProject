package com.capstone.retailStore.Customer.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    int customer_Id;

    @Column(name = "Name")
    String customerName;

    @Column(name = "BillingAddress")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "door_No", column = @Column(name = "BillingdoorNo")),
            @AttributeOverride(name = "streetName", column = @Column(name = "BillingstreetName")),
            @AttributeOverride(name = "layOut", column = @Column(name = "BillinglayOut")),
            @AttributeOverride(name = "city", column = @Column(name = "Billingcity")),
            @AttributeOverride(name = "pincode", column = @Column(name = "Billingpincode"))
    })
    Customer_Address customerBillingAddress;

    @Column(name = "ShippingAddress" )
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "door_No", column = @Column(name = "ShippingdoorNo")),
            @AttributeOverride(name = "streetName", column = @Column(name = "ShippingstreetName")),
            @AttributeOverride(name = "layOut", column = @Column(name = "ShippinglayOut")),
            @AttributeOverride(name = "city", column = @Column(name = "Shippingcity")),
            @AttributeOverride(name = "pincode", column = @Column(name = "Shippingpincode"))
    })
    Customer_Address customerShippingAddress;


}
