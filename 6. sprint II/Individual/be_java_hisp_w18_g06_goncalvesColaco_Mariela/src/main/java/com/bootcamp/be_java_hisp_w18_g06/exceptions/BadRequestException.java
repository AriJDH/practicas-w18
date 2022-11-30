package com.bootcamp.be_java_hisp_w18_g06.exceptions;

public class BadRequestException extends RuntimeException {
	public BadRequestException(String message) {
		super(message);
	}
}
