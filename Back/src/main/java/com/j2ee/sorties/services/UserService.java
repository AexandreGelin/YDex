package com.j2ee.sorties.services;

import java.util.List;
import java.util.Optional;

import com.j2ee.sorties.dto.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.j2ee.sorties.entities.User;
import com.j2ee.sorties.repositories.UserRepository;

@Service
public class UserService  {
	@Autowired
	private UserRepository userRepository;

	public User createOrUpdate(User user) {
		return userRepository.save(user);
	}

	public User getUserById(String username) {
		return userRepository.findById(username).orElse(null);
	}


	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Page<User> getUsersWithPaging(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	public void deleteUser(String username) {
		userRepository.deleteById(username);
	}


}