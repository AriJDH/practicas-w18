package com.linkTracker.services;

import com.linkTracker.dto.request.LinkDtoRequest;
import com.linkTracker.dto.response.LinkDtoResponse;
import com.linkTracker.entity.LinkEntity;
import com.linkTracker.repository.ILinkRepository;
import com.linkTracker.repository.LinkRepositoryIMP;

public class LinkServiceIMP implements ILinkService {
  private static Long id = 0L;

  ILinkRepository linkRepository;

  public LinkServiceIMP(LinkRepositoryIMP linkRepository) {
    this.linkRepository= linkRepository;
  }

  @Override
  public LinkDtoResponse createLink(LinkDtoRequest url) {
    linkRepository.createLink(new LinkEntity());
    return null;
  }

  @Override
  public int getAnalyticsById(Long id) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void deleteLink(Long id) {
    // TODO Auto-generated method stub

  }

  private Long createId() {
    return this.id++;
  }
}
