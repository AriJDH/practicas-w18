package com.link.linksproject.repository;

import com.link.linksproject.entity.LinkEntity;

public interface ILinkRepo {

    int createLink(LinkEntity link);

    void invalidateLink(int id);

    LinkEntity getLinkById(int id);

}
