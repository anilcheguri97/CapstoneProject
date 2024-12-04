/*
package com.capstone.retailStore.Customer.databases;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.capstone.retailStore.Customer.repository",
        entityManagerFactoryRef = "mainEntityManagerFactory",
        transactionManagerRef = "mainTransactionManager")
public class MainDatabaseConfiguration {

    @Primary
    @Bean(name = "mainDataSource")
    public DataSource mainDataSource() {
        return org.springframework.boot.jdbc.DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/JFSSpringBoot") // Replace with your MySQL URL
                .username("root") // Replace with your MySQL username
                .password("12345") // Replace with your MySQL password
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Primary
    @Bean(name = "mainEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mainEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
           DataSource mainDataSource) {
        return  builder
                .dataSource(mainDataSource)
                .packages("com.capstone.retailStore.Customer.databases")
                .persistenceUnit("main")
                .build();
    }


    @Primary
    @Bean(name = "mainTransactionManager")
    public PlatformTransactionManager mainTransactionManager(
            EntityManagerFactory mainEntityManagerFactory) {
        return new JpaTransactionManager(mainEntityManagerFactory);
    }

}
*/
