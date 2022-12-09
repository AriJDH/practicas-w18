package com.RecapitulandoSpringP2VIVO.linkTracker.service;

import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDto;
import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDtoRes;

import java.util.List;

public interface ILinkService {
	LinkDtoRes addLink(LinkDto linkDto);
	LinkDto getLink(Integer id);
	List<LinkDto> getLinks();
	
}
