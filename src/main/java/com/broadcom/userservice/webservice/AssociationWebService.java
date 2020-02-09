package com.broadcom.userservice.webservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broadcom.userservice.beans.RequestObjects.AddPrivilegeToRoleReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToGroupReq;
import com.broadcom.userservice.beans.RequestObjects.AddRoleToUserReq;
import com.broadcom.userservice.beans.RequestObjects.AddUserToGroupReq;
import com.broadcom.userservice.beans.ResponseObjects.WebResponse;

@RestController
@RequestMapping("/associate")
public class AssociationWebService {

	@PostMapping(value = "/usertogroup", produces = "application/json")
    WebResponse addUserToGroup(@RequestBody AddUserToGroupReq req) {
		return null;
    }

	@PostMapping(value = "/privilegetorole", produces = "application/json")
    WebResponse addPrivilegeToRole(@RequestBody AddPrivilegeToRoleReq req) {
		return null;
    }

	@PostMapping(value = "/roletouser", produces = "application/json")
    WebResponse addRoleToUser(@RequestBody AddRoleToUserReq req) {
		return null;
    }

	@PostMapping(value = "/roletogroup", produces = "application/json")
    WebResponse addRoleToGroup(@RequestBody AddRoleToGroupReq req) {
		return null;
    }

}
