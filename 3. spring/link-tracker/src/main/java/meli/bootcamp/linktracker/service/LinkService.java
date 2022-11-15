package meli.bootcamp.linktracker.service;

import meli.bootcamp.linktracker.entity.LinkDto;
import meli.bootcamp.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository linkRepository;

    @Override
    public LinkDto createLink(LinkDto linkDtoRes) {
        return linkRepository.createLink(linkDtoRes);
    }

    @Override
    public LinkDto redirectLink(Integer id) {
        return linkRepository.redirectLink(id);
    }

    @Override
    public LinkDto getStatisticsLink(Integer id) {
        return linkRepository.getStatisticsLink(id);
    }

    @Override
    public void deleteLink(Integer id) {
        linkRepository.deleteLink(id);
    }
}
