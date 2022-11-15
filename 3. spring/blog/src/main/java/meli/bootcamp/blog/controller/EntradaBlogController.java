package meli.bootcamp.blog.controller;

import meli.bootcamp.blog.dto.request.EntradaBlogDto;
import meli.bootcamp.blog.dto.response.SalidaMensajeDTO;
import meli.bootcamp.blog.service.BlogService;
import meli.bootcamp.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EntradaBlogController {

    @Autowired
    private IBlogService blogService;

    @PostMapping
    public ResponseEntity<SalidaMensajeDTO> crearEntradaBlog(@RequestBody EntradaBlogDto entradaDTO){
        blogService.createEntradaBlog(entradaDTO);
        SalidaMensajeDTO salida = new SalidaMensajeDTO();
        salida.setMensaje("Se creo Correctamente la entrada con id " + entradaDTO.getId());
        return new ResponseEntity(salida,
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<EntradaBlogDto> getAllEntradaBlog(){
        return new ResponseEntity(blogService.getAllEntradaBlog(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> getEntradaBlogById(@PathVariable int id){
        return new ResponseEntity(blogService.getEntradaBlog(id),HttpStatus.OK);
    }
}
