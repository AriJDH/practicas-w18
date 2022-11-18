package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkDTO;
import com.mercadolibre.linktracker.dto.LinkDTOCreate;
import com.mercadolibre.linktracker.service.ILinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class LinkController {
    private final ILinkService linkService;

    @PostMapping("")
    public ResponseEntity<LinkDTO> createLink(@RequestBody LinkDTOCreate linkDto){
        return ResponseEntity.ok(linkService.create(linkDto));
    }

    @GetMapping("/link/{linkId}/auth")
    public void redirect(@PathVariable Long linkId,
                                 @RequestParam String pass,
                                 //ModelMap modelMap){
                                 HttpServletResponse res){
        //modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");
        //return new ModelAndView("redirect:"+linkService.redirect(linkId, pass), modelMap);
        res.setHeader("Location", linkService.redirect(linkId, pass));
        res.setStatus(302);

    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<Integer> getMetrics(@PathVariable Long linkId){
        return ResponseEntity.ok(linkService.getMetrics(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Long linkId){
        linkService.invalidate(linkId);
        return ResponseEntity.ok().build();
    }
}
