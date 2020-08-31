package com.huma.genbe.model.dto;

public class ErrorDtoOutput {
	private String status;
	private String message;
	private PersonDtoOutput data;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PersonDtoOutput getData() {
		return data;
	}
	public void setData(PersonDtoOutput data) {
		this.data = data;
	}


}
