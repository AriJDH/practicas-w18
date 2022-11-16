package com.example.linktracker.repository;


import com.example.linktracker.entity.Link;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository

public class LinkRepositoryImp implements ILinkRepository{

    private Map<Integer,Link> linkMap = new HashMap<>();


    @Override
    public Integer createLink(Link link) {
        linkMap.put(linkMap.size()+1,link);
        return linkMap.size();
    }


    @Override
    public Link getLinkById(Integer id) {
        return linkMap.get(id);
    }

    @Override
    public void invalidateLink(Integer id) {
        linkMap.get(id).setIsValid(false);
    }

    @Override
    public void countAccessLink(Integer id) {
        linkMap.get(id).setCount(linkMap.get(id).getCount()+1);
    }
}
