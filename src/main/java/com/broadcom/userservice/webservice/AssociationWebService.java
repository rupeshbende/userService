package com.broadcom.userservice.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadcom.userservice.beans.RequestObjects.AddPrivilegeToRoleByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddPrivilegeToRoleReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToGroupByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToGroupReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToUserByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToUserReq;
import com.broadcom.userservice.beans.RequestObjects.AddUserToGroupByIdReq;
import com.broadcom.userservice.beans.RequestObjects.AddUserToGroupReq;
import com.broadcom.userservice.beans.ResponseObjects.WebResponse;
import com.broadcom.userservice.service.AssociationService;

@RestController
@RequestMapping("/associate")
public class AssociationWebService {

	@Autowired
	AssociationService service;
	
	@PostMapping(value = "/usertogroup", produces = "application/json")
    public WebResponse addUserToGroup(@RequestBody AddUserToGroupReq req) {
		service.addUserToGroup(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/privilegetorole", produces = "application/json")
    public WebResponse addPrivilegeToRole(@RequestBody AddPrivilegeToRoleReq req) {
		service.addPrivilegeToRole(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/roletouser", produces = "application/json")
	public WebResponse addRoleToUser(@RequestBody AddRoleToUserReq req) {
		service.addRoleToUser(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/roletogroup", produces = "application/json")
	public WebResponse addRoleToGroup(@RequestBody AddRoleToGroupReq req) {
		service.addRoleToGroup(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/usertogroup", produces = "application/json")
    public WebResponse addUserToGroup(@RequestBody AddUserToGroupByIdReq req) {
		service.addUserToGroup(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/privilegetorole", produces = "application/json")
    public WebResponse addPrivilegeToRole(@RequestBody AddPrivilegeToRoleByIdReq req) {
		service.addPrivilegeToRole(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/roletouser", produces = "application/json")
	public WebResponse addRoleToUser(@RequestBody AddRoleToUserByIdReq req) {
		service.addRoleToUser(req);
		return new WebResponse(true);
    }

	@PostMapping(value = "/roletogroup", produces = "application/json")
	public WebResponse addRoleToGroup(@RequestBody AddRoleToGroupByIdReq req) {
		service.addRoleToGroup(req);
		return new WebResponse(true);
    }

}
