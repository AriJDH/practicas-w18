package com.example.spring.excepciones.tracker.repository;

import com.example.spring.excepciones.tracker.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements ILinkRepository {
    private int lastId = 1;
    private HashMap<Integer, Link> mapLinks = new HashMap<>();


    @Override
    public int createLink(Link link) {
        mapLinks.put(lastId, link);
        return lastId++;  //para que devuelva el id actual y luego lo incremente

    }

    public Link getUrl(int id){
        return mapLinks.get(id);
    }
}
