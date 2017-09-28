package com.fsalac.form.web.dto;

public class APIResponse {
	
	private String status;
	private Object data;
	private String message;
	private String warning;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static APIResponse createAPIResponse(String status, Object data, String message) {
		
		APIResponse apiResponse = new APIResponse();
		apiResponse.setStatus(status);
		apiResponse.setData(data);
		apiResponse.setMessage(message);
		
		return apiResponse;
	}

	public String getWarning() {
		return warning;
	}

	public void setWarning(String warning) {
		this.warning = warning;
	}

}
