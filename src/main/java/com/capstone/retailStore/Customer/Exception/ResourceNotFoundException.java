package com.capstone.retailStore.Customer.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){

    }
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
