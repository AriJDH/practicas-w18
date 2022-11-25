package com.jcundere.ejerciciopractico09.service;

import com.jcundere.ejerciciopractico09.dto.request.LinkRequest;
import com.jcundere.ejerciciopractico09.dto.response.LinkResponse;
import com.jcundere.ejerciciopractico09.entity.LinkEntity;

public interface ILinkService {

    LinkResponse createLink(LinkRequest request);

    LinkEntity getLinkById(Integer linkId);

    String getRedirectByLinkId(Integer linkId, String password);

    void invalidateLinkById(Integer linkId);

}
