package com.example.weatherapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.weatherapi.exceptions.*;
import com.example.weatherapi.models.Users;
import com.example.weatherapi.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	// Post Actions
	
	// Create a new user
	// Throw exception if required fields are missing
	// Throw exception if user already exists
	// Else return user
	@PostMapping("/users")
	public Users createUser(@RequestBody Users user) throws Exception {
		try{
			return userService.saveUser(user);
		} catch(EmptyFieldException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
		} catch(InvalidEmailException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
		} catch(UserAlreadyExists e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	// Update an existing user
	// Throw exception if user not found
	// Throw exception if required fields are missing
	// Throw exception if email is invalid
	// Else return user
	@PostMapping("/users/{id}")
	public Users updateUser(@PathVariable int id, @RequestBody Users user) throws Exception {
		try {
			return userService.updateUser(id, user);
		} catch(UserNotFoundException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch(EmptyFieldException e) {
			throw new ResponseStatusException(HttpStatus.NO_CONTENT, e.getMessage());
		} catch(InvalidEmailException e) {
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
		} catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// Get Actions
	
	// Get all users
	@GetMapping("/users")
	public List<Users> getAllUsers() throws Exception {
		return userService.getAllUsers();
	}

	// Get a single user
	// If the user does not exist, throw a 404 error else return the user
	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable int id) throws Exception {
		try{
			Users user = userService.getUserById(id);
			return user;
		} catch(UserNotFoundException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
	}

	// Login a user
	// If the user does not exist, throw a 404 error else return the user
	@GetMapping("/users/login")
	public ResponseEntity<Users> loginUser(@RequestBody Users user) throws Exception {
		try{
			final HttpHeaders httpHeaders= new HttpHeaders();
    		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			Users userLogin = userService.loginUser(user);
			return new ResponseEntity<Users>(userLogin, httpHeaders, HttpStatus.OK);
		} catch(UserNotFoundException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch(InvalidAuthenticationException e){
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
		} catch(Exception e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	
	// Delete a user
	// If the user does not exist, throw a 404 error else delete the user
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id) throws Exception {
		try{
			final HttpHeaders httpHeaders= new HttpHeaders();
    		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			userService.deleteUser(id);
			try {
                Users node = userService.getUserById(id);
                return new ResponseEntity<String>("{\"message\": \"User Deletion Failed\"}", httpHeaders, HttpStatus.CONFLICT);
            } catch(NodeNotFoundException e) {
                return new ResponseEntity<String>("{\"message\": \"User Deleted Successfully\"}", httpHeaders, HttpStatus.ACCEPTED);
            }
		} catch(UserNotFoundException e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		} catch(Exception e){
			System.out.println(e.getMessage());
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
	}
}
