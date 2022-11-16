package com.example.link.repository;

import com.example.link.domain.Link;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LinkRepository {

    Link crear(Link link);

    Link findById(Long id);


}
