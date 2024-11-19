package com.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.main.dto.UserRequest;
import com.main.entity.UserEntity;
import com.main.repository.UserRepository;
import com.main.translator.UserTranslator;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Component
public class UserService {

	@Autowired
	private UserTranslator translator;
	
	@Autowired
	private UserRepository repository;
	
	//create user
	@Transactional
	public String createUser(UserRequest request) {
		log.info("here user srevice are run and save the user");
		UserEntity user = translator.toentity(request);
		repository.save(user);
		return "create Successfully";
	}
	
	//update user by id
    @Transactional
    public String updateUser(UserRequest request, Long id) {
        log.info("Updating user with ID: {}", id);
        
        UserEntity existingUser = repository.findById(id).orElse(null);

        if (existingUser == null) {
            log.warn("User with ID {} not found.", id);
            return "User not found!";
        }
        existingUser.setId(id);
        UserEntity user = translator.toentity(request);
		repository.save(user);
        return "User updated successfully!";
    }
 // Fetch user by ID
    public UserEntity getUserById(Long id) {
        log.info("Fetching user with ID: {}", id);
        return repository.findById(id).orElse(null);     
    }

 // Fetch all user details
    public List<UserEntity> fetchAllUserDetails() {
        log.info("Fetching all user details...");
        return repository.findAll();
    }


    // Delete user by ID
    @Transactional
    public String deleteUserById(Long id) {
        log.info("Deleting user with ID: {}", id);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "User deleted successfully!";
        } else {
            log.warn("User with ID {} not found.", id);
            return "User not found!";
        }
    }

    // Delete all users
    @Transactional
    public String deleteAllUsers() {
        log.info("Deleting all users...");
        repository.deleteAll();
        return "All users deleted successfully!";
    }
}
