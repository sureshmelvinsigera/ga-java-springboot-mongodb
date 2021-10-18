package com.example.springbootmongo.service;

import com.example.springbootmongo.model.User;
import com.example.springbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//without @Service, cannot find Bean
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    //methods
    @Override
    public List<User> listUsers(){
        //finds all and lists the users from userRepository
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser){
        //saves that one particular object in userRepository
        //then returns that newUser
        return userRepository.save(newUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
