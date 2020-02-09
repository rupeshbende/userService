package com.broadcom.userservice.webservice;

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

import com.broadcom.userservice.beans.RequestObjects.Role;
import com.broadcom.userservice.beans.ResponseObjects.WebResponse;
import com.broadcom.userservice.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleWebService {
	
	@Autowired
	RoleService service;

	@GetMapping(value = "/{roleId}", produces = "application/json")
	public Role getRole(@PathVariable @Positive(message = "Invalid roleId") int roleId) {
		return service.getRole(roleId);
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	public WebResponse createRole(@RequestBody Role role) {
		int roleId = service.createRole(role);
		if(roleId>0)
			return new WebResponse(true);
		return new WebResponse(false);
    }
 
    @PutMapping(value = "/{roleId}", produces = "application/json")
    public WebResponse updateRole(@RequestBody Role role, @PathVariable @Positive(message = "Invalid roleId") Long roleId) {
    	service.updateRole(role);
    	return new WebResponse(true);
    }
 
    @DeleteMapping("/{roleId}")
    public WebResponse deleteRole(@PathVariable @Positive(message = "Invalid roleId") int roleId) {
    	service.deleteRole(roleId);
    	return new WebResponse(true);
    }
    
}
