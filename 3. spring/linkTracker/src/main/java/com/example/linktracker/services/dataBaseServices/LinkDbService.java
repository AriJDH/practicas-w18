package com.example.linktracker.services.dataBaseServices;

import com.example.linktracker.entities.Link;

public interface LinkDbService {
    Link findById(long id);
    void add(Link link);
}
