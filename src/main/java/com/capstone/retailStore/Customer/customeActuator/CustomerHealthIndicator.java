package com.capstone.retailStore.Customer.customeActuator;

import com.capstone.retailStore.Customer.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomerHealthIndicator implements HealthIndicator {
    private static  final Logger LOGGER = LoggerFactory.getLogger(CustomerHealthIndicator.class);
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();
        LOGGER.info("customized health indicator is in info");
        LOGGER.debug("customized health indicator is in debug");
        LOGGER.warn("customized health indicator is in warn");
        LOGGER.error("customized health indicator is in error");
        if(customerRepository.count()>1) {
            builder.down();
            LOGGER.info("customized health indicator is down in info");
            LOGGER.debug("customized health indicator is down in debug");
            LOGGER.warn("customized health indicator is down in warn");
            LOGGER.error("customized health indicator is down in error");
        }else {
            builder.up();
            LOGGER.info("customized health indicator is up in info");
            LOGGER.debug("customized health indicator is up in debug");
            LOGGER.warn("customized health indicator is up in warn");
            LOGGER.error("customized health indicator is up in error");
        }
        return builder.build();
    }
}
