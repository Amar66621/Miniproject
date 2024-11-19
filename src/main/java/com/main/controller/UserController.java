package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.UserRequest;
import com.main.entity.UserEntity;
import com.main.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody UserRequest request){
		return ResponseEntity.ok(service.createUser(request));
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody UserRequest request) {
        String response = service.updateUser(request, id);
        if ("User not found!".equals(response)) {
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.ok(response);
    }
	 // Fetch user by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        UserEntity user = service.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.ok(user);
    }
    // Fetch all users
    @GetMapping("/getall")
    public ResponseEntity<List<UserEntity>> fetchAllUsers() {
        List<UserEntity> users = service.fetchAllUserDetails();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        String response = service.deleteUserById(id);
        if ("User not found!".equals(response)) {
            return ResponseEntity.status(404).body(response);
        }
        return ResponseEntity.ok(response);
    }

    // Delete all users
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllUsers() {
        return ResponseEntity.ok(service.deleteAllUsers());
    }
}
