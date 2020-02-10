package com.broadcom.userservice.beans;

public class WebResponse {
	String status;
	public WebResponse(boolean isSuccess) {
		if(isSuccess)
			status = "Success";
		else
			status = "Failed";
	}
	
	@Override
	public String toString() {
		return "WebResponse [status=" + status + "]";
	}
	
}
