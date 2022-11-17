package com.linktracker.linktracker.services;

import com.linktracker.linktracker.dtos.request.LinkReqDTO;
import com.linktracker.linktracker.dtos.response.IdDTO;
import com.linktracker.linktracker.dtos.response.LinkResDTO;
import com.linktracker.linktracker.entities.Link;

public interface IService {
    IdDTO createLink(LinkReqDTO linkReqDTO);
    LinkResDTO redirect(int id);
    LinkResDTO metrics(int id);
    void invalidateLinkLink(int id);
}
