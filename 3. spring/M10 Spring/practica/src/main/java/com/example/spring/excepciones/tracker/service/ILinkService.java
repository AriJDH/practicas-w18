package com.example.spring.excepciones.tracker.service;

import com.example.spring.excepciones.tracker.dto.request.LinkDTOReq;
import com.example.spring.excepciones.tracker.dto.response.LinkDTORes;

public interface ILinkService {

    LinkDTORes createLink(LinkDTOReq linkDTOReq);

    LinkDTORes getLink(LinkDTOReq linkDTOReq);

}
