package com.manejoExcepcionesVivo.youtuber.util;

import com.manejoExcepcionesVivo.youtuber.exception.IdDuplicadoException;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessageDTO {
	
	private String message;
	private Integer code;
	
	public ErrorMessageDTO(IdDuplicadoException e) {
		this.message = e.getMessage();
		this.code = e.getCode();
	}
}
