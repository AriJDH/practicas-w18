package com.example.hql.service;

import com.example.hql.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements IEpisodeService {

    private final EpisodeRepository episodeRepository;


    @Override
    public List<String[]> getAllEpisodeWithActorEqualsTo(String actorFirstName, String actorLastName) {

        return episodeRepository.getAllEpisodeWithActorEqualsTo(actorFirstName,actorLastName);
    }

}
