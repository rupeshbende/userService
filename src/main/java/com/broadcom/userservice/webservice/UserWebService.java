package com.broadcom.userservice.webservice;

import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadcom.userservice.beans.UserDetails;
import com.broadcom.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserWebService {

	@Autowired
	UserService service;
	
	@GetMapping(value = "/{userId}", produces = "application/json")
	public UserDetails getUser(@PathVariable @Positive(message = "Invalid userId") long userId) {
		return null;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
    UserDetails createUser(@RequestBody UserDetails user) {
		return null;
    }
 
    @PutMapping(value = "/{userId}", produces = "application/json")
    UserDetails updateUser(@RequestBody UserDetails user, @PathVariable @Positive(message = "Invalid userId") Long userId) {
    	return null;
    }
 
    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable @Positive(message = "Invalid userId") Long userId) {
 
    }
    
    @GetMapping(value ="/groups/{userId}", produces = "application/json")
    List<String> getGroups(){
    	return null;
    }

    @GetMapping(value ="/roles/{userId}", produces = "application/json")
    List<String> getRolesByUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	return null;
    }

    @GetMapping(value ="/roles/{email}", produces = "application/json")
    List<String> getRolesByUserEmail(){
    	return null;
    }

    @GetMapping(value ="/privileges/{userId}", produces = "application/json")
    List<String> getPrivilegesbyUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	return null;
    }
    
    @GetMapping(value ="/privileges/{email}", produces = "application/json")
    List<String> getPrivilegesByUserEmail(){
    	return null;
    }
    
}
