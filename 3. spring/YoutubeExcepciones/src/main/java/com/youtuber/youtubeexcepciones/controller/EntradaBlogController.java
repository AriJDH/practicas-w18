package com.youtuber.youtubeexcepciones.controller;

import com.youtuber.youtubeexcepciones.DTO.EntradaBlogDTO;
import com.youtuber.youtubeexcepciones.DTO.SalidaMensajeDTO;
import com.youtuber.youtubeexcepciones.service.IService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrada")
public class EntradaBlogController {

    @Autowired
    private IService serivce;

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDTO> getEntradaBlogById(@PathVariable int id){
        return new ResponseEntity(serivce.getEntradaBlogDTO(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<EntradaBlogDTO> getAllEntradaBlog(){
        return new ResponseEntity(serivce.getAllEntradaDTOBlogs(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SalidaMensajeDTO> crearEntradaBlog(@RequestBody EntradaBlogDTO entradaDTO){
        serivce.createEntradaBlogDTO(entradaDTO);
        SalidaMensajeDTO salida = new SalidaMensajeDTO();
        salida.setMessage("Se creo Correctamente la entrada con id " + entradaDTO.getId());
        return new ResponseEntity(salida,
                HttpStatus.CREATED);
    }
}
