package com.myApp.Mine.service;

import com.myApp.Mine.entity.UserPrincipal;
import com.myApp.Mine.entity.Users;
import com.myApp.Mine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if(user == null) {
            System.out.println("user not found ");
            throw new UsernameNotFoundException("user not found");

        }


        return new UserPrincipal(user);
    }
}
