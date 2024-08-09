package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public User usersave(User user) {
        // Encode the password before saving
    	User U=new User();
        U.setPassword(user.getPassword());
        U.setRole(user.getRole());
        U.setUsername(user.getUsername());
        userRepository.save(user);
        return user;
    }

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}

