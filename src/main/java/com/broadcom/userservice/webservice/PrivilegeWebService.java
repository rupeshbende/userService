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

import com.broadcom.userservice.beans.Privilege;
import com.broadcom.userservice.beans.WebResponse;
import com.broadcom.userservice.service.PrivilegeService;

@RestController
@RequestMapping("/privilege")
public class PrivilegeWebService {

	//TODO javax validations on request objects
	
	@Autowired
	PrivilegeService service;
	
	@GetMapping(value = "/{privilegeId}", produces = "application/json")
	public Privilege getPrivilege(@PathVariable @Positive(message = "Invalid privilegeId") int privilegeId) {
		return service.getPrivilege(privilegeId);
	}
	
	@PostMapping(value = "/create", produces = "application/json")
	public WebResponse createPrivilege(@RequestBody Privilege privilege) {
		int privelegeId = service.createPrivilege(privilege);
		if(privelegeId>0)
			return new WebResponse(true);
		return new WebResponse(false);
    }
 
    @PutMapping(value = "/{privilegeId}", produces = "application/json")
    public WebResponse updatePrivilege(@RequestBody Privilege privilege, @PathVariable @Positive(message = "Invalid privilegeId") Long privilegeId) {
    	service.updatePrivilege(privilege);
    	return new WebResponse(true);
    }
 
    @DeleteMapping("/{privilegeId}")
    public WebResponse deletePrivilege(@PathVariable @Positive(message = "Invalid privilegeId") int privilegeId) {
    	service.deletePrivilege(privilegeId);
    	return new WebResponse(true);
    }
}
