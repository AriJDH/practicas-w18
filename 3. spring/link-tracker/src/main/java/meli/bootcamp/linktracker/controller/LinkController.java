package meli.bootcamp.linktracker.controller;

import meli.bootcamp.linktracker.entity.LinkDto;
import meli.bootcamp.linktracker.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/create")
    public ResponseEntity<LinkDto> createLink(@RequestBody LinkDto linkDto)
    {
        linkService.createLink(linkDto);
        return new ResponseEntity<>(linkDto, HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public RedirectView redirectLink(@PathVariable Integer id)
    {
        LinkDto linkDto = linkService.redirectLink(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(linkDto.getLink());
        return redirectView;
    }

    @GetMapping("/metrics/{id}")
    public ResponseEntity<LinkDto> getStatisticsLink(@PathVariable Integer id)
    {
        LinkDto linkDto = linkService.getStatisticsLink(id);
        return new ResponseEntity<>(linkDto, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public void deleteLink(@PathVariable Integer id)
    {
        linkService.deleteLink(id);
    }
}
