package com.example.movies_hql.controller;

import com.example.movies_hql.dto.ActorDTO;
import com.example.movies_hql.service.IActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class ActorController {

    private final IActorService iActorService;

    public ActorController(IActorService iActorService) {
        this.iActorService = iActorService;
    }

    @GetMapping("/buscarActoresConPeliculaFavorita")
    public ResponseEntity<List<ActorDTO>> buscarActoresConPeliculaFavorita() {
        return ResponseEntity.ok(this.iActorService.buscarActoresConPeliculaFavorita());
    }

    @GetMapping("/buscarActoresPorRating")
    public ResponseEntity<List<ActorDTO>> buscarActoresPorRating(@RequestParam("rating") BigDecimal rating) {
        return ResponseEntity.ok(this.iActorService.buscarActoresPorRating(rating));
    }

    @GetMapping("/buscarActoresPorPelicula")
    public ResponseEntity<List<ActorDTO>> buscarActoresPorPelicula(@RequestParam("nombrePelicula") String nombrePelicula) {
        return ResponseEntity.ok(this.iActorService.buscarActoresPorPelicula(nombrePelicula));
    }
}
