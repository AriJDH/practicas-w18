package meli.bootcamp.linktracker.repository;

import meli.bootcamp.linktracker.entity.LinkDto;

public interface ILinkRepository {
    LinkDto createLink(LinkDto linkDtoRes);

    LinkDto redirectLink(Integer id);

    LinkDto getStatisticsLink(Integer id);

    void deleteLink(Integer id);
}
