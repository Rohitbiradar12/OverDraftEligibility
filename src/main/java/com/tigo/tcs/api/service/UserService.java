package com.tigo.tcs.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tigo.tcs.TCSRequest;
import com.tigo.tcs.api.entity.User;
import com.tigo.tcs.api.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public boolean validateUser(TCSRequest request) {
		Optional<User> user = userRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
		return user.isPresent();	
	}

}
