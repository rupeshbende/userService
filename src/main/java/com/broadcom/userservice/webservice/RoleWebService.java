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

import com.broadcom.userservice.beans.RoleDetails;
import com.broadcom.userservice.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleWebService {
	
	@Autowired
	RoleService service;

	@GetMapping(value = "/{roleId}", produces = "application/json")
	public RoleDetails getRole(@PathVariable @Positive(message = "Invalid roleId") long roleId) {
		return null;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	RoleDetails createRole(@RequestBody RoleDetails role) {
		return null;
    }
 
    @PutMapping(value = "/{roleId}", produces = "application/json")
    RoleDetails updateRole(@RequestBody RoleDetails role, @PathVariable @Positive(message = "Invalid roleId") Long roleId) {
    	return null;
    }
 
    @DeleteMapping("/{roleId}")
    void deleteRole(@PathVariable @Positive(message = "Invalid roleId") Long roleId) {
 
    }
    
}
