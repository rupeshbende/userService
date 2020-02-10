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

import com.broadcom.userservice.beans.Group;
import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.beans.Role;
import com.broadcom.userservice.beans.User;
import com.broadcom.userservice.beans.WebResponse;
import com.broadcom.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserWebService {

	//TODO javax validations on request objects
	
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
    List<Group> getGroups(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	return service.getUserGroups(userId);
    }

    @GetMapping(value ="/roles/{userId}", produces = "application/json")
    List<Role> getRolesByUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	return service.getUserRoles(userId);
    }

    @GetMapping(value ="/roles/{email}", produces = "application/json")
    List<Role> getRolesByUserEmail(@PathVariable String email){
    	//TODO add email validations
    	return service.getUserRolesByEmail(email);
    }

    @GetMapping(value ="/privileges/{userId}", produces = "application/json")
    List<Privilege> getPrivilegesbyUserId(@PathVariable @Positive(message = "Invalid userId") Long userId){
    	return service.getUserPrivileges(userId);
    }
    
    @GetMapping(value ="/privileges/{email}", produces = "application/json")
    List<Privilege> getPrivilegesByUserEmail(@PathVariable String email){
    	//TODO Add email validations
    	return service.getUserPrivilegesByEmail(email);
    }
    
}
