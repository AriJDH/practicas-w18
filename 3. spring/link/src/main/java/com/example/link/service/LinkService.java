package com.example.link.service;

import com.example.link.domain.Link;
import com.example.link.dto.LinkDto;
import com.example.link.dto.LinkIdDto;

public interface LinkService {

    LinkIdDto crear(LinkDto link);

    String path(Long id);
}
