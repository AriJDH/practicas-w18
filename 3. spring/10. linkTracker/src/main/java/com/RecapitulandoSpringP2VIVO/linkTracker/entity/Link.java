package com.RecapitulandoSpringP2VIVO.linkTracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Link {

	private Long id;
	private String url;
	private Boolean validated;
	private Integer count;
}
