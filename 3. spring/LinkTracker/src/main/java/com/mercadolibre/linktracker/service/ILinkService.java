package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkDTOCreate;
import org.springframework.web.servlet.view.RedirectView;

public interface ILinkService {

    LinkDTO create(LinkDTOCreate link);
    String redirect(Long linkId, String pass);
    Integer getMetrics(Long linkId);
    void invalidate(Long id);


}
