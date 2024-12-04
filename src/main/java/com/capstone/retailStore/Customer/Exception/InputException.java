package com.capstone.retailStore.Customer.Exception;

import com.capstone.retailStore.Customer.customeActuator.CustomerHealthIndicator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InputException extends RuntimeException{
    private static  final Logger LOGGER = LoggerFactory.getLogger(InputException.class);
    InputException() {

    }
    public InputException(String msg){
        super(msg);
        LOGGER.info("customized input exception  is created in info");
        LOGGER.debug("customized input exception  is created in debug");
        LOGGER.warn("customized input exception  is created in warn");
        LOGGER.error("customized input exception  is created in error");
    }
}
