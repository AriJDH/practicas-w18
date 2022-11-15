package com.example.linktracker.service;

import com.example.linktracker.entity.Link;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {

    Long createLink(String url);

    RedirectView redirect(Long linkId);

    void deleteLink(Long linkId);

    Link findById(Long linkId);

    Integer getMetrics(Long linkId);
}
