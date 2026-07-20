package com.example.demo.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GenericExceptionResponse {
	
	LocalDateTime timeStamp; 
	int status; 
	String message;
	public GenericExceptionResponse(LocalDateTime timeStamp, int status, String message) {
	
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 
	
	
}
