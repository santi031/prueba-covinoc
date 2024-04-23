package com.covinoc.prueba.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.covinoc.prueba.models.User;
import com.covinoc.prueba.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/consult-users")
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/consult-user/{userId}")
	public Optional<User> getUser(@PathVariable Long userId) {
		return userService.getUserByIdentification(userId);
	}

	@PostMapping("/create-user")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/update-user/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable Long userId,@RequestBody User user) {
		return userService.updateUser(userId, user);
	}

	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}
}
