/*
package com.capstone.retailStore.Customer.databases;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.capstone.retailStore.Customer.Security", // Replace with your secondary database repositories
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager"
)
public class SecondaryDatabase {
    @Bean(name = "SecondaryDataBase")
    public DataSource secondaryDataSource() {
        return org.springframework.boot.jdbc.DataSourceBuilder
                .create().url("jdbc:h2:mem:testdb").username("sa")
                .password("12345").
                driverClassName("org.h2.Driver").build();
    }

    @Bean(name = "secondaryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource secondaryDataSource) {
        return builder
                .dataSource(secondaryDataSource)
                .packages("com.capstone.retailStore.Customer.Security") // Replace with your secondary database entity package
                .persistenceUnit("secondary")
                .build();
    }

    @Bean(name = "secondaryTransactionManager")
    public PlatformTransactionManager secondaryTransactionManager(
            EntityManagerFactory secondaryEntityManagerFactory) {
        return new JpaTransactionManager(secondaryEntityManagerFactory);
    }
}
*/
