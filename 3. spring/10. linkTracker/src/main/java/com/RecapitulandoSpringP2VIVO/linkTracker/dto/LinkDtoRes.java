package com.RecapitulandoSpringP2VIVO.linkTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkDtoRes {
	
	private Integer id;
	private String url;
	private Boolean isValidUrl;
	
}
