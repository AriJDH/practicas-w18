package com.spring.linktracker.repository;

import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.utils.LinkMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private static List<Link> linkList;

    @Override
    public Link createLink(Link link) {
        LinkMapper.entity2Response(link);
        linkList.add(link);
        return link;
    }

    @Override
    public int getAnaliticsById(Long linkId) {
        return 0;
    }

    @Override
    public void invalidateLink(Long linkId) {

    }

}
