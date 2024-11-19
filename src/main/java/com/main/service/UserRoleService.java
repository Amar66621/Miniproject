package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.dto.UserRoleRequest;
import com.main.entity.UserRole;
import com.main.repository.UserRoleReository;
import com.main.translator.UserTranslator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserRoleService {

    @Autowired
    private UserRoleReository repository;

    @Autowired
    private UserTranslator translator;

    // Create user role
    public ResponseEntity<String> createUserRole(UserRoleRequest request) {
        log.info("Creating user role and saving to the database...");
        UserRole entity = translator.toRoleEntity(request);
        repository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body("UserRole created successfully");
    }

    // Update user role
    public ResponseEntity<String> updateUserRole(Long id, UserRoleRequest request) {
        log.info("Updating user role with ID: {}", id);
        UserRole existingRole = repository.findById(id).orElse(null);

        if (existingRole == null) {
            log.warn("UserRole with ID {} not found.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserRole not found");
        }
        existingRole.setId(id);
        UserRole entity = translator.toRoleEntity(request);
        repository.save(entity);
        
        return ResponseEntity.status(HttpStatus.OK).body("UserRole updated successfully");
    }

    // Fetch user role by ID
    public ResponseEntity<UserRole> getUserRoleById(Long id) {
        log.info("Fetching user role with ID: {}", id);
        UserRole userRole = repository.findById(id).orElse(null);

        if (userRole == null) {
            log.warn("UserRole with ID {} not found.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(userRole);
    }

    // Fetch all user roles
    public ResponseEntity<List<UserRole>> getAllUserRoles() {
        log.info("Fetching all user roles...");
        List<UserRole> userRoles = repository.findAll();

        if (userRoles.isEmpty()) {
            log.warn("No user roles found.");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(userRoles);
        }

        return ResponseEntity.ok(userRoles);
    }

    // Delete user role by ID
    public ResponseEntity<String> deleteUserRoleById(Long id) {
        log.info("Deleting user role with ID: {}", id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("UserRole deleted successfully");
        } else {
            log.warn("UserRole with ID {} not found.", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UserRole not found");
        }
    }

    // Delete all user roles
    public ResponseEntity<String> deleteAllUserRoles() {
        log.info("Deleting all user roles...");
        repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All user roles deleted successfully");
    }
}
