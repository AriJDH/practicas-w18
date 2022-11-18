package com.spring.linktracker.repository;

import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.utils.LinkMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{

    private static ArrayList<Link> linkList;

    public LinkRepository(){
        linkList = new ArrayList<>();
    }
    @Override
    public LinkDtoRes createLink(Link link) {
        linkList.add(link);
        return LinkMapper.entity2Response(link);
    }

    @Override
    public LinkDtoRes searchLink(Long linkId){
        LinkDtoRes result = null;
        for (Link link : linkList){
            if( link.getId().equals(linkId))
                result = LinkMapper.entity2Response(link);
        }
        return result;
    }

    @Override
    public LinkDtoRes searchLinkById(Long linkId){
        LinkDtoRes result = null;
        for (Link link : linkList){
            if( link.getId().equals(linkId))
                result = LinkMapper.entity2Response(link);
                result.setUrl("www.redirected.net." + result.getUrl());
        }
        return result;
    }

    @Override
    public Link searchLinkForAnalitics(Long linkId){
        Link result = null;
        for (Link link : linkList){
            if( link.getId().equals(linkId))
                result = link;
        }
        return result;
    }

    @Override
    public Integer getAnaliticsById(Long linkId) {
        return searchLinkForAnalitics(linkId).getRedirectCount();
    }

    @Override
    public void invalidateLink(Long linkId) {

    }

    @Override
    public void addAnalitycsByID(Long linkId) {
        for(Link lista : linkList){
            if (lista.getId().equals(linkId)){
                lista.addRedirectCount();
            }
        }
    }

}
