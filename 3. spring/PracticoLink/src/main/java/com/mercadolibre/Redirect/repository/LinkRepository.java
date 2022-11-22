package com.mercadolibre.Redirect.repository;

import com.mercadolibre.Redirect.entity.Link;
import com.mercadolibre.Redirect.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository implements ILinkRepository{
    private List<Link> linkList = new ArrayList<>();
    @Override
    public Link createLink(Link link) {
        linkList.add(link);
        return link;
    }

    @Override
    public Integer getLinkCounter(int id) {
        for (Link link : linkList) {
            if(link.getId().equals(id)){
                return link.getCount();
            }
        }
        throw new NotFoundException("The link with id: "+id+" does not exist!");
    }

    @Override
    public void invalidateLink(int id) {
        for (Link link : linkList) {
            if(link.getId().equals(id)){
                linkList.remove(link);
                break;
            }
        }
        throw new NotFoundException("The link with id: "+id+" does not exist!");
    }

    @Override
    public Link redirectLink(int id, String password) {
        Link l = new Link();
        for (Link link : linkList) {
            if(link.getId().equals(id) && link.getPassword().equals(password)){
                link.setCount(link.getCount()+1);
                l.setId(link.getId());
                l.setUrl(link.getUrl());
                l.setCount(link.getCount());
                return l;
            }

        }
        return null;
    }

    @Override
    public Link findById(int id) {
        for (Link link : linkList) {
            if(link.getId().equals(id)){
                return link;
            }else{
                throw new NotFoundException("The link with id: "+id+" does not exist!");
            }
        }
        return null;
    }
}
