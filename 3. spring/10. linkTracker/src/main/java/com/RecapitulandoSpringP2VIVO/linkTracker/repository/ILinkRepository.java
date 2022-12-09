package com.RecapitulandoSpringP2VIVO.linkTracker.repository;

import com.RecapitulandoSpringP2VIVO.linkTracker.entity.Link;

import java.util.List;

public interface ILinkRepository {
	Integer addLink(Link link);
	Link getLink(Integer id);
	List<Link> getLinks();
}
