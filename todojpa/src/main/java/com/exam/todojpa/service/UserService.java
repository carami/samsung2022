package com.exam.todojpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.todojpa.domain.User;
import com.exam.todojpa.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String email) {
		return userRepository.findByEmail(email).get();
	}

}
