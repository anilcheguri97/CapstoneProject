package com.capstone.retailStore.Customer.Security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        /*UserDetails user = User.withUsername("test")
                .password(passwordEncoder().encode("test"))
                .roles("USER")
                .build();
        UserDetails admin = User.withUsername("test1").
                            password(passwordEncoder().
                            encode("test1")).
                            roles("ADMIN").build();   // hard coded Values
        return  new InMemoryUserDetailsManager(user,admin);*/
        return new MyUserDetailsService();

    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/usersapi/addUser").permitAll()
                        .requestMatchers("/customer/welcome").permitAll()
                        .requestMatchers("/actuator/refresh").permitAll()
                        .requestMatchers("/actuator/health").permitAll()
                        .requestMatchers("/customer/hello").hasRole("USER")
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults()); // Default login page
        return http.build();
    }
}
