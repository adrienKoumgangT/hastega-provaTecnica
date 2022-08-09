package io.github.adrienkoumgangt.api.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.github.adrienkoumgangt.api.model.User;
import io.github.adrienkoumgangt.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * Create - Add a new user
	 * @param user An object user
	 * @return The user object saved
	 */
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") final Integer id) {
		Optional<User> user = userService.getUser(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	
	/**
	 * Read - Get all users
	 * @return - An Iterable object of User full filled
	 */
	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	
	
	/**
	 * Update - Update an existing user
	 * @param id - The id of the user to update
	 * @param user - The user object updated
	 * @return
	 */
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") final Integer id, @RequestBody User user) {
		Optional<User> u = userService.getUser(id);
		if(u.isPresent()) {
			User currentUser = u.get();
			
			String firstName = user.getFirstName();
			if(firstName != null) {
				currentUser.setFirstName(firstName);
			}
			
			String lastName = user.getLastName();
			if(lastName != null) {
				currentUser.setLastName(lastName);
			}
			
			String username = user.getUsername();
			if(username != null) {
				currentUser.setUsername(username);
			}
			
			String email = user.getEmail();
			if(email != null) {
				currentUser.setEmail(email);
			}
			
			String password = user.getPassword();
			if(password != null) {
				currentUser.setPassword(password);
			}
			
			userService.saveUser(currentUser);
			return currentUser;
		} else {
			return null;
		}
	}
	
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") final Integer id) {
		userService.deleteUser(id);
	}

}
