package com.example.hql.service;

import java.util.List;

public interface IEpisodeService {

    List<String[]> getAllEpisodeWithActorEqualsTo(String actorFirstName, String actorLastName);

}
