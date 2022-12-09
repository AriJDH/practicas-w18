package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.response.JerwelyDtoResponse;
import com.example.joyerialasperlas.model.Jewerly;
import com.example.joyerialasperlas.service.IJewerlyService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
/*@RequestMapping("/jewerly")*/
public class JewerlyController {

    @Autowired
    private IJewerlyService jewerlyService;

    /**
     * Endpoint to create a jewerly
     * @param Jewerly
     * {
     *  "nombre" : "Anillo",
     * 	"material": "oro",
     * 	"peso": 300,
     * 	"particularidad" : "Otra particularidad",
     * 	"posee_piedra" : false,
     * 	"ventaONo" : true
     * }
     * @return HttpStatus - 200 OK (if success) or 400 Bad Request (if error)
     */
    @PostMapping("/jewerly/new")
    public ResponseEntity<JerwelyDtoResponse> createJewerly(@RequestBody Jewerly jewerly) throws Throwable{
        return new ResponseEntity<>(jewerlyService.guardarJoyas(jewerly), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Jewerly>> getAllJewerly() throws Throwable
    {
        return new ResponseEntity<>(jewerlyService.obtenerJoyas(),HttpStatus.OK);
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping ("/jewerly/delete/{id}")
    public ResponseEntity<JerwelyDtoResponse> deleteJoya (@PathVariable Long id) throws Throwable {

        return new ResponseEntity<>(jewerlyService.borrarJoyas(id),HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<Jewerly> editJoya (@PathVariable Long id_modificar, @RequestBody Jewerly joya) throws Throwable {

        return new ResponseEntity<>(jewerlyService.editarJoya(id_modificar, joya), HttpStatus.OK);
    }

}
