package com.linktracker.linktracker.services;

import com.linktracker.linktracker.dtos.request.LinkReqDTO;
import com.linktracker.linktracker.dtos.response.IdDTO;
import com.linktracker.linktracker.dtos.response.LinkResDTO;
import com.linktracker.linktracker.entities.Link;
import com.linktracker.linktracker.repository.IRepository;
import com.linktracker.linktracker.repository.Repository;


public class Service implements IService{

    IRepository linkRepository;

    public Service(Repository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public IdDTO createLink(LinkReqDTO linkReqDTO) {
        Link newLink = new Link(0, linkReqDTO.getLink(), linkReqDTO.getPassword(), 0);
        Integer newId = linkRepository.createLink(newLink);
        return new IdDTO(newId);
    }

    @Override
    public LinkResDTO redirect(int id) {
        Link link = linkRepository.getLinkById(id);
        LinkResDTO linkRes = new LinkResDTO(link.getLinkId(),link.getLink(), link.getCount());
        return null;
    }

    @Override
    public LinkResDTO metrics(int id) {
        return null;
    }

    @Override
    public void invalidateLinkLink(int id) {

    }
}
