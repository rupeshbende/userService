package com.broadcom.userservice.webservice;

import javax.validation.constraints.Positive;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadcom.userservice.beans.Role;

@RestController
@RequestMapping("/role")
public class RoleWebService {

	@GetMapping(value = "/{roleId}", produces = "application/json")
	public Role getRole(@PathVariable @Positive(message = "Invalid roleId") long roleId) {
		return null;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	Role createRole(@RequestBody Role role) {
		return null;
    }
 
    @PutMapping(value = "/{roleId}", produces = "application/json")
    Role updateRole(@RequestBody Role role, @PathVariable @Positive(message = "Invalid roleId") Long roleId) {
    	return null;
    }
 
    @DeleteMapping("/{roleId}")
    void deleteRole(@PathVariable @Positive(message = "Invalid roleId") Long roleId) {
 
    }
}
