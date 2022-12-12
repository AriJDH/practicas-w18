package com.example.obrasliterarias.controller;

import com.example.obrasliterarias.domain.Obra;
import com.example.obrasliterarias.service.ObraDbService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("obras")
public class ObraController {
    @Autowired
    private ObraDbService obraDbService;

    @PostMapping
    public ResponseEntity<Obra> save(@RequestBody Obra obra){
        return ResponseEntity.ok(obraDbService.save(obra));
    }

    @GetMapping
    public ResponseEntity<List<Obra>> findAll(){
        return ResponseEntity.ok(obraDbService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id){
        obraDbService.deleteById(id);
        return ResponseEntity.ok("La obra " + id + " ha sido eliminada.");
    }

    @GetMapping("/autor/{nombreAutor}")
    public ResponseEntity<Obra> findByNombreAutor(@PathVariable String nombreAutor){
        return ResponseEntity.ok(obraDbService.findByNombreAutor(nombreAutor));
    }

    @GetMapping("/titulo/{substring}")
    public ResponseEntity<List<Obra>> findByTitleSubstring(@PathVariable String substring){
        return ResponseEntity.ok(obraDbService.findByTitleSubstring(substring));
    }

    @GetMapping("/paginas/{cantidadPaginas}")
    public ResponseEntity<List<Obra>> findByPAgesGreaterThan(@PathVariable int cantidadPaginas){
        return ResponseEntity.ok(obraDbService.findByPagesGreaterThan(cantidadPaginas));
    }

    @GetMapping("/publicacion/anterior/{anio}")
    public ResponseEntity<List<Obra>> findAllPublishedBefore(@PathVariable int anio){
        return ResponseEntity.ok(obraDbService.findAllPublishedBefore(anio));
    }

    @GetMapping("/publicacion/posterior/{anio}")
    public ResponseEntity<List<Obra>> findAllPublishedAfter(@PathVariable int anio){
        return ResponseEntity.ok(obraDbService.findAllPublishedAfter(anio));
    }

    @GetMapping("/editorial/{nombreEditorial}")
    public ResponseEntity<List<Obra>> findAllByEditorial(@PathVariable String nombreEditorial){
        return ResponseEntity.ok(obraDbService.findAllByEditorial(nombreEditorial));
    }
}
