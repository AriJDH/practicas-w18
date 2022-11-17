package com.linktracker.linktracker.repository;

import com.linktracker.linktracker.entities.Link;
import com.linktracker.linktracker.exceptionconfig.NotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Repository implements IRepository{
    private final Map<Integer, Link> database = new HashMap<>();

    @Override
    public Integer createLink(Link link) {
        Integer newId = database.values().size() + 1;
        link.setLinkId(newId);
        database.put(newId, link);
        return newId;
    }

    @Override
    public Link getLinkById(int id) {
        Link link = database.getOrDefault(id,null);
        if ( link.equals(null) ){
            throw new NotFoundException("Link inválido");
        }
        return link;
    }

    @Override
    public void deleteLink(int id) {
        if ( !database.remove(id,database.get(id)) ) {
            throw  new NotFoundException("Link inválido");
        };
    }
}
