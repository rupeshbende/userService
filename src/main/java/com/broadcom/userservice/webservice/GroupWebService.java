package com.broadcom.userservice.webservice;

import java.util.ArrayList;
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

import com.broadcom.userservice.beans.RequestObjects.Group;
import com.broadcom.userservice.beans.ResponseObjects.WebResponse;
import com.broadcom.userservice.service.GroupService;

@RestController
@RequestMapping("/group")
public class GroupWebService {
	
	@Autowired
	GroupService service;
	
	@Autowired
	AssociationWebService associationService;
	
	@GetMapping(value = "/{groupId}", produces = "application/json")
	public Group getGroup(@PathVariable @Positive(message = "Invalid groupId") int groupId) {
		return service.getGroup(groupId);
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	public WebResponse createGroup(@RequestBody Group group) {
		int groupId = service.createGroup(group);
		if(groupId>0)
			return new WebResponse(true);
		return new WebResponse(false);
    }
 
    @PutMapping(value = "/{groupId}", produces = "application/json")
    public WebResponse updateGroup(@RequestBody Group group, @PathVariable @Positive(message = "Invalid groupId") Long groupId) {
    	service.updateGroup(group);
    	return new WebResponse(true);
    }
 
    @DeleteMapping("/{groupId}")
    public WebResponse deleteGroup(@PathVariable @Positive(message = "Invalid groupId") int groupId) {
    	service.deleteGroup(groupId);
    	return new WebResponse(true);
    }

	@GetMapping(value = "/privileges/{groupId}", produces = "application/json")
	public List<String> getPrivileges(@PathVariable @Positive(message = "Invalid groupId") int groupId) {
		List<String> privileges = new ArrayList<>();
		//TODO get privilegs of group
		return null;
	}
	
	@GetMapping(value = "/users/{groupId}", produces = "application/json")
	public List<Long> getUsers(@PathVariable @Positive(message = "Invalid groupId") long groupId) {
		//TODO get users of group
		return null;
	}
	
}
