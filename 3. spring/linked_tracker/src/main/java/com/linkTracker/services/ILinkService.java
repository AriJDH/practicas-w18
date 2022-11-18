package com.linkTracker.services;

import com.linkTracker.dto.request.LinkDtoRequest;
import com.linkTracker.dto.response.LinkDtoResponse;
import com.linkTracker.entity.LinkEntity;

public interface ILinkService {
  LinkDtoResponse createLink(LinkDtoRequest url);
  int getAnalyticsById(Long id);
  void deleteLink(Long id);
}
