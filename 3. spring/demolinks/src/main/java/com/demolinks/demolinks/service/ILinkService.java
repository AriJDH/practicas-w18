package com.demolinks.demolinks.service;

import com.demolinks.demolinks.dto.request.LinkDtoReq;
import com.demolinks.demolinks.dto.response.LinkDtoRes;
import com.demolinks.demolinks.dto.response.LinkStatisticDtoRes;

public interface ILinkService {
    LinkDtoRes createLink(LinkDtoReq linkDtoReq, String password);
    LinkStatisticDtoRes getLinkStatistic(Integer linkId);
    LinkDtoRes invalidateLink(LinkDtoReq linkDtoReq);


}
