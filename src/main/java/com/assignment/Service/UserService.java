package com.assignment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Entity.User;
import com.assignment.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public boolean verify(String userPassWord1, String userPassWord2) {
		if(userPassWord1.equals(userPassWord2)) {
			return true;
		}
		return false;
		
	}

	public void saveUser(User user) {
		userRepository.save(user);
		
	}

	public boolean verifyUsername(String userName) {
		return (userRepository.findByUserName(userName).isPresent());
		
	}

	public String authrnticate(String userName, String userPassWord) {
		
		if(!(userRepository.findByUserName(userName).isPresent())) {
			return "NP";
		}
		if(!(userRepository.findByUserName(userName).get().getUserPassword().equals(userPassWord))) {
			return "NM";
		}
		
		return "True";
		
	}

}
