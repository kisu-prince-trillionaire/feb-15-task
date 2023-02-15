package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bean.User;
import com.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/home")
	public String home() {
		return "Hello";
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		try {
			List<User> userList = service.getAllUser();
			if (userList.size() <= 0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(userList));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable String id) {
		try {
			User user = service.getUser(id);
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(user));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			User usr = service.addUser(user);
			return ResponseEntity.of(Optional.of(usr));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/users")
	public ResponseEntity<User> updateEmployee(@RequestBody User user) {
		try {
			this.service.updateUser(user);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
		try {
			String message = service.deleteUser(id);
			System.out.println(message);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
