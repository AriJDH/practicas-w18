package com.RecapitulandoSpringP2VIVO.linkTracker.repository;

import com.RecapitulandoSpringP2VIVO.linkTracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LinkRepository implements ILinkRepository {
	Map<Integer, Link> links = new HashMap<Integer, Link>();
	private Integer counter = 0;
	
	@Override
	public Integer addLink(Link link) {
		links.put(counter, link);
		counter++;
		return counter - 1;
	}
	
	@Override
	public Link getLink(Integer id) {
		return links.get(id);
	}
	
	@Override
	public List<Link> getLinks() {
		return new ArrayList<Link>(links.values());
	}
}
