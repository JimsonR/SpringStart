package com.myApp.Mine.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.lang.reflect.Array;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Autowired
private UserDetailsService userDetailsService;

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
//whenever we pass the details the username and password in the login form, that object when the server receives
// it sends basically an authentication object, which is still not authenticated it goes something called authentication provider\
// which provides the service of checking it and then making at as a authenticaion object
// authentication object -> authentication provider -> authentication object
// by default it is running behind the scene , now we want to customize it
// since we want to use custom authentication provider
// and that authentication provider can be used to connect with database or ltab services
// We create a bean to change our default authentication provider itself
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();// we use this since it implements Authentication provider
        provider.setPasswordEncoder( new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;

}


//    @Bean
//    public UserDetailsService userDetails(){
//    UserDetails user1 = User.withDefaultPasswordEncoder()
//            .username("jim")
//            .password("j123")
//            .roles("USER")
//            .build();
//
//    UserDetails user2 = User.withDefaultPasswordEncoder()
//                .username("jyots")
//                .password("j231")
//                .roles("ADMIN")
//                .build();
//
//    return new InMemoryUserDetailsManager(user1,user2);
//    } // since we are not getting data from db we comment this
}
