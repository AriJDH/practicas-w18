package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.LinkMetricsDTO;
import com.example.linktracker.dtos.LinkReceptionDTO;

public interface LinkService {
    LinkDTO createLink(LinkReceptionDTO linkReceptionDTO);
    String getRedirectionLink(long id, String password);
    LinkMetricsDTO getMetrics(long id);
    void invalidateLink(long id);
}
