package com.link.linksproject.service;

import com.link.linksproject.dto.LinkDTO;
import com.link.linksproject.dto.LinkDTOreq;
import com.link.linksproject.entity.LinkEntity;

public interface ILinkService {

    int createLink(LinkDTOreq link);

    void invalidateLink(int id);

    LinkDTO getLinkById(int id);

    String redirectById(int id, String password);

}
