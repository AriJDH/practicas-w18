package com.linkTracker.repository;

import com.linkTracker.entity.LinkEntity;

public interface ILinkRepository {
  LinkEntity createLink(LinkEntity link);
  int getAnalyticsById(Long id);
  void deleteLink(Long id);
}
