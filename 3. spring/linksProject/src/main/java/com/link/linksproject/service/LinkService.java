package com.link.linksproject.service;

import com.link.linksproject.dto.LinkDTO;
import com.link.linksproject.dto.LinkDTOreq;
import com.link.linksproject.entity.LinkEntity;
import com.link.linksproject.excepciones.PasswordErrorException;
import com.link.linksproject.excepciones.URLInvalidaExcepcion;
import com.link.linksproject.repository.ILinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class LinkService implements ILinkService {

    @Autowired
    private ILinkRepo repo;

    @Override
    public int createLink(LinkDTOreq link) {
        if (!isValid(link.getUrl()))
            throw new URLInvalidaExcepcion("URL invalida");

        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setHabilitado(true);
        linkEntity.setLink(link.getUrl());
        linkEntity.setPassword(link.getPassword());
        linkEntity.setCantidadRedirigida(0);

        return repo.createLink(linkEntity);
    }

    @Override
    public void invalidateLink(int id) {
        repo.invalidateLink(id);
    }

    @Override
    public LinkDTO getLinkById(int id) {
        LinkEntity linkEntity = repo.getLinkById(id);

        LinkDTO linkDTO = new LinkDTO();
        linkDTO.setId(linkEntity.getId());
        linkDTO.setHabilitado(linkEntity.isHabilitado());
        linkDTO.setPassword(linkEntity.getPassword());
        linkDTO.setLink(linkEntity.getLink());
        linkDTO.setCantidadRedirigida(linkEntity.getCantidadRedirigida());

        return linkDTO;
    }

    @Override
    public String redirectById(int id, String password) {
        LinkEntity linkEntity = repo.getLinkById(id);
        if(linkEntity.getPassword().equals(password))
            return linkEntity.getLink();

        throw new PasswordErrorException("Contraseña invalida para el id " + id);
    }

    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
