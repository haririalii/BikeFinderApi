package com.police.bikeFinder.bikeFinderApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException {
	public InvalidInputException(String message , String detail) {
		super(message);
		this.detail = detail;
	}
	private String detail;

	public String getDetail() {
		return detail;
	}
}
