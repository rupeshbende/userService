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

import com.broadcom.userservice.beans.Privilege;

@RestController
@RequestMapping("/privilege")
public class PrivilegeWebService {

	@GetMapping(value = "/{privilegeId}", produces = "application/json")
	public Privilege getPrivilege(@PathVariable @Positive(message = "Invalid privilegeId") long privilegeId) {
		return null;
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	Privilege createPrivilege(@RequestBody Privilege privilege) {
		return null;
    }
 
    @PutMapping(value = "/{privilegeId}", produces = "application/json")
    Privilege updatePrivilege(@RequestBody Privilege privilege, @PathVariable @Positive(message = "Invalid privilegeId") Long privilegeId) {
    	return null;
    }
 
    @DeleteMapping("/{privilegeId}")
    void deletePrivilege(@PathVariable @Positive(message = "Invalid privilegeId") Long privilegeId) {
 
    }
}
