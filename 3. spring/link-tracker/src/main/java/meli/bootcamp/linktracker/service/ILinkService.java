package meli.bootcamp.linktracker.service;

import meli.bootcamp.linktracker.entity.LinkDto;

public interface ILinkService {
    LinkDto createLink(LinkDto linkDtoRes);

    LinkDto redirectLink(Integer id);

    LinkDto getStatisticsLink(Integer id);

    void deleteLink(Integer id);
}
