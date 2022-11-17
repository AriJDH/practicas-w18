package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entities.Link;

public interface IRepository {
    Integer createLink(Link link);
    Link getLinkById(int id);
    void deleteLink(int id);
}
