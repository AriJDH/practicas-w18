package com.demolinks.demolinks.repository;

import com.demolinks.demolinks.entity.Link;

import java.util.Optional;

public interface ILinkRepository {

    Boolean createLink(Link link);
    Optional<Link> findLink(Integer linkId);
    Boolean removeLink(Integer linkId);
    int getLinkIdCounter();
}
