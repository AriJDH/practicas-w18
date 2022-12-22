package com.example.hql.controller;

import com.example.hql.service.IEpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
@RequiredArgsConstructor
public class EpisodeController {

    private final IEpisodeService episodeService;


    @GetMapping("query7")
    public ResponseEntity<?> getQuery7(@RequestParam(name = "actor_first_name") String actorFirstName,
                                       @RequestParam(name = "actor_last_name") String actorLastName) {

        return new ResponseEntity<>(episodeService.getAllEpisodeWithActorEqualsTo(actorFirstName, actorLastName), HttpStatus.OK);
    }

}
