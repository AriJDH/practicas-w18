package com.linkTracker.repository;

import com.linkTracker.dto.request.LinkDtoRequest;
import com.linkTracker.dto.response.LinkDtoResponse;
import com.linkTracker.entity.LinkEntity;
import java.util.List;
import org.w3c.dom.Entity;

public class LinkRepositoryIMP implements ILinkRepository {
  private static List<LinkEntity> linkList;

  @Override
  public LinkEntity createLink(LinkEntity link) {
    linkList.add(link);
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

  public LinkDtoResponse convertEntityToDtoResponse(Long id) {
    LinkDtoResponse linkDtoResponse = new LinkDtoResponse();

    for (LinkEntity storedLink : linkList) {
      if (storedLink.getId() == id) {
        // nextLinkDto
      }
    }

    return linkDtoResponse;
  }
}
