package com.capstone.retailStore.Customer.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyControllerAdvice.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody MyExceptionFormat handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest req) {
        LOGGER.info("controller advice  is called for ResourceNotFoundException  in info");
        LOGGER.debug("controller advice  is called for ResourceNotFoundException in debug");
        LOGGER.warn("controller advice  is called for ResourceNotFoundException in warn");
        LOGGER.error("controller advice  is called for ResourceNotFoundException in error");
        return getExceptionDetails(exception, req);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody MyExceptionFormat handleException(Exception exception, HttpServletRequest req) {
        LOGGER.info("controller advice  is called for Exception  in info");
        LOGGER.debug("controller advice  is called for Exception in debug");
        LOGGER.warn("controller advice  is called for Exception in warn");
        LOGGER.error("controller advice  is called for Exception in error");
        return getExceptionDetails(exception, req);
    }

    @ExceptionHandler(InputException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody MyExceptionFormat handleInputException(InputException exception, HttpServletRequest req) {
        LOGGER.info("controller advice  is called for InputException  in info");
        LOGGER.debug("controller advice  is called for InputException in debug");
        LOGGER.warn("controller advice  is called for InputException in warn");
        LOGGER.error("controller advice  is called for InputException in error");
        return getExceptionDetails(exception, req);
    }
    @ExceptionHandler(CustomerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody MyExceptionFormat handleCustomerNotFound(CustomerNotFoundException exception,HttpServletRequest req) {
        LOGGER.info("controller advice  is callled for CustomerNotFoundException  in info");
        LOGGER.debug("controller advice  is callled for CustomerNotFoundException in debug");
        LOGGER.warn("controller advice  is callled for CustomerNotFoundException in warn");
        LOGGER.error("controller advice  is callled for CustomerNotFoundException in error");
        return getExceptionDetails(exception,req);
    }
    public MyExceptionFormat getExceptionDetails(Exception exception, HttpServletRequest req) {
        MyExceptionFormat myExceptionFormat = new MyExceptionFormat();
        myExceptionFormat.setMessage(exception.getMessage());
        myExceptionFormat.setPath(req.getRequestURI());
        return myExceptionFormat;
    }

}
