package com.example.linktracker.service;

import com.example.linktracker.dto.req.LinkDTOReq;
import com.example.linktracker.dto.resp.LinkCreatedDTOResp;
import com.example.linktracker.dto.resp.LinkDTOResp;
import com.example.linktracker.entity.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkService {

    LinkCreatedDTOResp createLink(LinkDTOReq linkDTOReq, String password);
    LinkDTOResp redirect(Integer id);
    Integer countAccessLink(Integer id);
    void invalidateLink(Integer id);
}
