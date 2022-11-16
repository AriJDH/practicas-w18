package com.link.controller;
import com.link.dto.LinkRequestDTO;
import com.link.dto.LinkResponseEstadisticaDTO;
import com.link.dto.LinkResponseIdDTO;
import com.link.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private ILinkService iLinkService;

    public LinkController( ILinkService iLinkService ){
        this.iLinkService = iLinkService;
    }

    @PostMapping("/crearLink")
    public ResponseEntity<LinkResponseIdDTO> add(@RequestBody LinkRequestDTO request){
        return new ResponseEntity<>(iLinkService.addLink(request), HttpStatus.CREATED);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<LinkResponseEstadisticaDTO> estadisticas(@PathVariable Long linkID){
        return new ResponseEntity<>(iLinkService.obtenerEstadisticas(linkID), HttpStatus.OK);
    }

    @PostMapping("/link/{linkID}")
    public ResponseEntity<LinkResponseIdDTO> redirect(@PathVariable Long linkID,
                                                               @RequestParam String password){
        return new ResponseEntity<>(iLinkService.redireccionarLink(linkID, password), HttpStatus.MULTIPLE_CHOICES);
    }

    @PostMapping("/invalidate/{linkID}")
    public ResponseEntity<LinkResponseIdDTO> invalidar(@PathVariable Long linkID){
        return new ResponseEntity<>(iLinkService.invalidarLink(linkID), HttpStatus.CREATED);
    }

}
