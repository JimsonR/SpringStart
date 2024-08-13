package com.myApp.Mine.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(customizer -> customizer.disable()); // to disable the csrf token
//
//        http.authorizeHttpRequests(request ->request.anyRequest().authenticated()); //by doing this we are asaying , no one could access this page without authentication
//        // although we are snding username and password, in no way wwe are using it here, to use it here
//        // enable the form login
//        http.formLogin(Customizer.withDefaults());// although it works for normal webpages it wont work for rest api calls(for postman it shows form as raw output)
//        http.httpBasic(Customizer.withDefaults());// this makes it such that post man ca access it
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // builder pattern
        http.csrf(customizer -> customizer.disable())
        .authorizeHttpRequests(request ->request.anyRequest().authenticated())
        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//                customizer.disable();
//            }
//        };
//        http.csrf(custCsrf); // this is what happens internally for every method above
//
        return http.build();
    }
}
