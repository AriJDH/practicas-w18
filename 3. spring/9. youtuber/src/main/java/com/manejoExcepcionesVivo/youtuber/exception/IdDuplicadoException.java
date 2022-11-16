package com.manejoExcepcionesVivo.youtuber.exception;

import lombok.Getter;

@Getter
public class IdDuplicadoException extends RuntimeException{
	
	private final Integer code = 409;
	public IdDuplicadoException(String message) {
		super(message);
	}
}
