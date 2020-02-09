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

import com.broadcom.userservice.beans.RequestObjects.User;
import com.broadcom.userservice.beans.ResponseObjects.WebResponse;
import com.broadcom.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserWebService {

	@Autowired
	UserService service;
	
	@GetMapping(value = "/{userId}", produces = "application/json")
	public User getUser(@PathVariable @Positive(message = "Invalid userId") long userId) {
		return service.getUser(userId);
	}
	
	@PostMapping(value = "/create", produces = "application/json")
    public WebResponse createUser(@RequestBody User user) {
		long userId = service.createUser(user);
		if(userId>0)
			return new WebResponse(true);
		return new WebResponse(false);
    }
 
    @PutMapping(value = "/{userId}", produces = "application/json")
    public WebResponse updateUser(@RequestBody User user, @PathVariable @Positive(message = "Invalid userId") Long userId) {
    	service.updateUser(user);
    	return new WebResponse(true);
    }
 
    @DeleteMapping("/{userId}")
    public WebResponse deleteUser(@PathVariable @Positive(message = "Invalid userId") Long userId) {
    	service.deleteUser(userId);
    	return new WebResponse(true);
    }
    
    @GetMapping(value ="/groups/{userId}", produces = "application/json")
    List<String> getGroups(){
    	//TODO get groups
    	return null;
    }

    @GetMapping(value ="/roles/{userId}", produces = "application/json")
    List<String> getRolesByUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	//TODO get roles
    	return null;
    }

    @GetMapping(value ="/roles/{email}", produces = "application/json")
    List<String> getRolesByUserEmail(){
    	//TODO get Roles
    	return null;
    }

    @GetMapping(value ="/privileges/{userId}", produces = "application/json")
    List<String> getPrivilegesbyUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	//TODO get Privileges
    	return null;
    }
    
    @GetMapping(value ="/privileges/{email}", produces = "application/json")
    List<String> getPrivilegesByUserEmail(){
    	//TODO get privileges
    	return null;
    }
    
}
