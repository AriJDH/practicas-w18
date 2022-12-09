package com.RecapitulandoSpringP2VIVO.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
	
	private Integer errorCode;
	private String message;
}
