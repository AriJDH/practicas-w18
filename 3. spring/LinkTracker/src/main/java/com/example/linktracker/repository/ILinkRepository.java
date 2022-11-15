package com.example.linktracker.repository;

import com.example.linktracker.entity.Link;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

public interface ILinkRepository {
    Long createLink(String url);

    RedirectView redirect(Long linkId);

    void deleteLink(Long linkId);

    Link findById(Long linkId);

    Integer getMetrics(Long linkId);


}
