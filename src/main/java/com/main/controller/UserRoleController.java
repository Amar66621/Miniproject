package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.main.dto.UserRoleRequest;
import com.main.entity.UserRole;
import com.main.service.UserRoleService;

import java.util.List;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService service;

    // Create a new user role
    @PostMapping("/createrole")
    public ResponseEntity<String> createUserRole(@RequestBody UserRoleRequest request) {
        return service.createUserRole(request);
    }

    // Update an existing user role by ID
    @PutMapping("/updaterole/{id}")
    public ResponseEntity<String> updateUserRole(@PathVariable Long id, @RequestBody UserRoleRequest request) {
        return service.updateUserRole(id, request);
    }

    // Fetch a user role by ID
    @GetMapping("/getrole{id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable Long id) {
        return service.getUserRoleById(id);
    }

    // Fetch all user roles
    @GetMapping("/getroleall")
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        return service.getAllUserRoles();
    }

    // Delete a user role by ID
    @DeleteMapping("/deleterole/{id}")
    public ResponseEntity<String> deleteUserRoleById(@PathVariable Long id) {
        return service.deleteUserRoleById(id);
    }

    // Delete all user roles
    @DeleteMapping("/deleteAllrole")
    public ResponseEntity<String> deleteAllUserRoles() {
        return service.deleteAllUserRoles();
    }
}
