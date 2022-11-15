package com.iseeyou.linktracker.service;

import com.iseeyou.linktracker.dto.request.LinkDTOReq;
import com.iseeyou.linktracker.dto.response.LinkDTORes;
import com.iseeyou.linktracker.dto.response.LinkStatisticDTORes;

public interface ILinkService {
    LinkDTORes createLink(LinkDTOReq linkDTOReq, String password);
    // redirereccionar
    LinkStatisticDTORes getLinkStatistic(Integer linkId);
    void invalidateLink(LinkDTOReq linkDTOReq);
}
