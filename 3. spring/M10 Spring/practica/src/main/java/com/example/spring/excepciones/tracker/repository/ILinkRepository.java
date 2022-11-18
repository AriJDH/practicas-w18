package com.example.spring.excepciones.tracker.repository;

import com.example.spring.excepciones.tracker.entity.Link;

public interface ILinkRepository {

    int createLink(Link link);

    Link getUrl (int id);

}
