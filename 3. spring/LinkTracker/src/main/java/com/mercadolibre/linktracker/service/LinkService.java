package com.mercadolibre.linktracker.service;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkDTOCreate;
import com.mercadolibre.linktracker.entity.Link;
import com.mercadolibre.linktracker.exception.InvalidPassException;
import com.mercadolibre.linktracker.repository.ILinkRepository;
import com.mercadolibre.linktracker.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkService implements ILinkService{
    private final ILinkRepository linkRepository;

    @Override
    public LinkDTO create(LinkDTOCreate link) {

        linkRepository.create(Util.MAPPER.convertValue(link, Link.class));
        return Util.MAPPER.convertValue(link, LinkDTO.class);
    }

    @Override
    public String redirect(Long linkId, String pass) {
        Link link = linkRepository.findById(linkId);
        if (!link.getPassword().equals(pass))
            throw new InvalidPassException("Acceso Denegado");
        return link.getLink();
    }

    @Override
    public Integer getMetrics(Long linkId) {
        return linkRepository.getMetrics(linkId);
    }

    @Override
    public void invalidate(Long linkId) {
        linkRepository.invalidate(linkId);
    }
}
