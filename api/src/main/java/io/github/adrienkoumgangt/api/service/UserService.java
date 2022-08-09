package io.github.adrienkoumgangt.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.adrienkoumgangt.api.model.User;
import io.github.adrienkoumgangt.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public Optional<User> getUser(final Integer id) {
		return userRepository.findById(id);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	public void deleteUser(final Integer id) {
		userRepository.deleteById(id);
	}
	
	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

}
