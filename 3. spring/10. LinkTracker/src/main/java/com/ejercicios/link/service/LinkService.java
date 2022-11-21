package com.ejercicios.link.service;

import com.ejercicios.link.dto.LinkDto;
import com.ejercicios.link.dto.LinkIdDto;

public interface LinkService {

    LinkIdDto crear(LinkDto link);

    String path(Long id);
}
