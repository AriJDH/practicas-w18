package com.dh.linktracker.repository;

import com.dh.linktracker.entity.Link;

import java.util.List;

public interface ILinkRepository {
    Integer addLink(Link link);
    Link getLink(Integer id);
    List<Link> getLinks();

}
