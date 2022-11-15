package com.dh.linktracker.service;

import com.dh.linktracker.dto.LinkDTO;
import com.dh.linktracker.dto.LinkDTOres;

import java.util.List;

public interface ILinkService {

    LinkDTOres addLink(LinkDTO linkDTO);
    LinkDTO getLink(Integer id);
    List<LinkDTO> getLinks();

}
