package meli.bootcamp.linktracker.repository;

import meli.bootcamp.linktracker.entity.LinkDto;
import meli.bootcamp.linktracker.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepository implements ILinkRepository {
    private HashMap<Integer, LinkDto> linkMap = new HashMap<>();

    @Override
    public LinkDto createLink(LinkDto linkDtoRes) {
        linkMap.put(linkDtoRes.getId(),linkDtoRes);
        return linkDtoRes;
    }

    @Override
    public LinkDto redirectLink(Integer id) {
        LinkDto linkDto = linkMap.get(id);
        if (linkDto == null)
        {
            throw new NotFoundException("No se encontro el id");
        }
        return linkDto;
    }

    @Override
    public LinkDto getStatisticsLink(Integer id) {
        System.out.println(id);
        System.out.println(linkMap);
        LinkDto linkDtoRes = linkMap.get(id);
        System.out.println(linkDtoRes);
        if (linkDtoRes == null)
        {
            throw new NotFoundException("No se encontro el id");
        }
        return linkDtoRes;
    }

    @Override
    public void deleteLink(Integer id) {
        linkMap.remove(id);
    }
}
