/**
 * 
 */
package com.elearning.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.LoginDto;
import com.elearning.model.User;
import com.elearning.repository.ApplicationRepositoryUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author I330976
 *
 */
@RestController
@RequestMapping(value="/api")
public class WebController {
	
	@Autowired
	private ApplicationRepositoryUtil applicationRepositoryUtil;
	
	private Map<Integer, User> users = new HashMap<Integer, User>(){
		 
		{
	        put(1, new User("1", "Mary", "Taylor","user1", "pass","99999"));
	        put(2, new User("2", "Peter", "Smith","user2", "pass","32324"));
	        put(3, new User("3", "newName", "Taylor","user3", "pass", "324234"));
	    }
	};
	
	@GetMapping(value="/users",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll(){
		List<User> results = users.entrySet().stream()
									.map(entry ->entry.getValue())
									.collect(Collectors.toList());
		return results;
	}
	
	@GetMapping(value="/users/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable int userId){
		return this.users.get(userId);
	}
	
	@PostMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE)
	public User create(@RequestBody User user){
		System.out.println("\n\ncalling");
		System.out.println(user);
		System.out.println(user.getPassword());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());
		System.out.println(user.getMobileNumber());
		System.out.println(user.getUserName());
		applicationRepositoryUtil.createUser(user);
		return user;
	}
	
	
	@PostMapping(value="/authenticate", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody LoginDto loginDto){
		System.out.println("\n\ncalling");
		System.out.println(loginDto);
		System.out.println(loginDto.getPassword());
		System.out.println(loginDto.getUserName());		
		User user = applicationRepositoryUtil.AuthenticateUser(loginDto);
		if(user != null)
			return new ResponseEntity<User>(user, HttpStatus.OK);
		return null;
	}

}
