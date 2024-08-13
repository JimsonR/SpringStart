package com.myApp.Mine.service;

import com.myApp.Mine.entity.Users;
import com.myApp.Mine.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
@Autowired
private UserRepo repo;
    public Users register(Users user){
        return repo.save(user);
    }
}
