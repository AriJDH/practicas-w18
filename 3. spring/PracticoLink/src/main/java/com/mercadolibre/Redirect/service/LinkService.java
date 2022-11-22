package com.mercadolibre.Redirect.service;

import com.mercadolibre.Redirect.dto.request.LinkRequestDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseCounterDTO;
import com.mercadolibre.Redirect.dto.response.LinkResponseIdDTO;
import com.mercadolibre.Redirect.entity.Link;
import com.mercadolibre.Redirect.exception.NotFoundException;
import com.mercadolibre.Redirect.repository.ILinkRepository;
import com.mercadolibre.Redirect.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    ILinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkResponseIdDTO addLink(LinkRequestDTO linkRequestDTO) {
        Link link = new Link(
                linkRequestDTO.getId(),
                linkRequestDTO.getUrl(),
                linkRequestDTO.getPassword()
        );

        return new LinkResponseIdDTO(
                linkRepository.createLink(link).getId(),
                "Link successfully created!"
        );
    }

    @Override
    public LinkResponseCounterDTO getLinkCounter(Integer id) {
        Integer count = linkRepository.getLinkCounter(id);
        if(count == null){
            throw new NotFoundException("The link with id: "+id+" does not exist!");
        }
        return new LinkResponseCounterDTO(id, count);
    }

    @Override
    public LinkResponseIdDTO invalidateLink(Integer id) {
        Link link = linkRepository.findById(id);
        if(link == null){
            throw new NotFoundException("the link with id "+id+" not exist");
        }
        linkRepository.invalidateLink(id);
        return new LinkResponseIdDTO(id, "Link invalidate successfully");
    }

    @Override
    public LinkResponseIdDTO redirectLink(Integer id, String password) {
        Link link = linkRepository.redirectLink(id, password);
        if(link == null){
            throw new NotFoundException("the link with id "+id+" not exist or the password is incorrect");
        }else if(link.isInvalidating()){
            throw new NotFoundException("the link with id "+id+" is invalid");
        }

        return new LinkResponseIdDTO(id, "Successfully redirect!");
    }
}
