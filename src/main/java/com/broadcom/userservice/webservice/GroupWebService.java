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

import com.broadcom.userservice.beans.GroupDetails;
import com.broadcom.userservice.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupWebService {
	
	@Autowired
	GroupService service;
	
	@GetMapping(value = "/{groupId}", produces = "application/json")
	public GroupDetails getGroup(@PathVariable @Positive(message = "Invalid groupId") long groupId) {
		return null;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	GroupDetails createGroup(@RequestBody GroupDetails group) {
		return null;
    }
 
    @PutMapping(value = "/{groupId}", produces = "application/json")
    GroupDetails updateGroup(@RequestBody GroupDetails group, @PathVariable @Positive(message = "Invalid groupId") Long groupId) {
    	return null;
    }
 
    @DeleteMapping("/{groupId}")
    void deleteGroup(@PathVariable @Positive(message = "Invalid groupId") Long groupId) {
 
    }

	@GetMapping(value = "/privileges/{groupId}", produces = "application/json")
	public List<String> getPrivileges(@PathVariable @Positive(message = "Invalid groupId") long groupId) {
		return null;
	}
	
	@GetMapping(value = "/users/{groupId}", produces = "application/json")
	public List<Long> getUsers(@PathVariable @Positive(message = "Invalid groupId") long groupId) {
		return null;
	}
	
}
