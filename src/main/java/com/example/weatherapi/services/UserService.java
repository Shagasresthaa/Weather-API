package com.example.weatherapi.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.Users;
import com.example.weatherapi.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public static final Pattern VALID_MAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	// Get all users
	// @return List of users
	// @throws Exception
	public List<Users> getAllUsers() throws Exception {
		return userRepository.findAll();
	}

	// Save a user
	// Return the saved user
	
	public Users saveUser(Users user) throws Exception {
		Boolean usr = userRepository.findByUserEmail(user.getUserEmail()) != null;
		if(user.getUserName() == null || user.getUserEmail() == null || user.getUserPass() == null) {
			throw new EmptyFieldException("expected fields are missing");		
		}
		else if(usr){
			throw new UserAlreadyExists("User already exists");
		}
		else if(!VALID_MAIL_PATTERN.matcher(user.getUserEmail()).matches()) {
			throw new InvalidEmailException("Invalid Email");
		}
		else {
			return userRepository.save(user);
		}
    }

	// Get a user by id
	// @return User
	// @throws Exception
	public Users getUserById(int id) throws Exception {
		Optional<Users> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new UserNotFoundException("User not found");
	}

	// Login a user
	// @return User
	// @throws Exception
	public Users loginUser(Users user) throws Exception {

		Users authUser = userRepository.findByUserEmail(user.getUserEmail());
		if(authUser == null) {
			throw new UserNotFoundException("User not found");
		}
		else if(!authUser.getUserPass().equals(user.getUserPass())) {
			throw new InvalidAuthenticationException("Invalid password");
		}
		else {
			return authUser;
		}
	}
	
	// Update a user
	// @return User
	// @throws Exception
	public Users updateUser(int id, Users user) throws Exception {
		if(user.getUserName() == null || user.getUserEmail() == null || user.getUserPass() == null) {
			throw new EmptyFieldException("expected fields are missing");		
		}
		if(!VALID_MAIL_PATTERN.matcher(user.getUserEmail()).matches()) {
			throw new InvalidEmailException("Invalid Email");
		}
		Optional<Users> user1 = userRepository.findById(id);		
		if(user1 == null) {
			throw new UserNotFoundException("User not found");
		}
		return userRepository.save(user);
	}

	// Delete a user
	// @return User
	// @throws Exception
	public Optional<Users> deleteUser(int id) throws Exception {
		Optional<Users> user = userRepository.findById(id);
		if(user == null) {
			throw new UserNotFoundException("User not found");
		}
		userRepository.deleteById(id);
		return user;
	}


}	
