package com.dh.linktracker.service;

import com.dh.linktracker.dto.LinkDTO;
import com.dh.linktracker.dto.LinkDTOres;
import com.dh.linktracker.entity.Link;
import com.dh.linktracker.repository.ILinkRepository;
import com.dh.linktracker.repository.LinkRepository;
import com.dh.linktracker.util.HandleURL;
import com.dh.linktracker.util.MapperSingleton;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class LinkService implements ILinkService{
    private final ILinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTOres addLink(LinkDTO linkDTO) {
        Link link = MapperSingleton.getInstance().map(linkDTO, Link.class);

        if( HandleURL.isValidURL(linkDTO.getUrl()) ) {
            link.setValidated(true);
            Integer id = linkRepository.addLink(link);
            LinkDTOres linkDTOres = MapperSingleton.getInstance().map(linkDTO, LinkDTOres.class);
            linkDTOres.setId(id);
            linkDTOres.setIsValidURL(true);
            return linkDTOres;
        }

        return null;
    }

    @Override
    public LinkDTO getLink(Integer id) {
        return null;
    }

    @Override
    public List<LinkDTO> getLinks() {
        return null;
    }
}
