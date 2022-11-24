package deporte.controller;

import deporte.dto.req.DeporteReqDTO;
import deporte.dto.resp.DeporteDTO;
import deporte.dto.resp.DeporteNivelDTO;
import deporte.service.DeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeporteController {

    private DeporteService deporteService = new DeporteService();
    @PostMapping("/create")
    public ResponseEntity<String> createDeporte(@RequestBody DeporteReqDTO deporteReqDTO){
        deporteService.crearDeporte(deporteReqDTO);
        return new ResponseEntity<>("Create", HttpStatus.CREATED);
    }

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return new ResponseEntity<>(deporteService.findSport(),HttpStatus.OK);
    }

    @GetMapping("findSports/{nombre}")
    public  ResponseEntity<DeporteNivelDTO> findSportNivel(@PathVariable String nombre){
        return new ResponseEntity<>(deporteService.findSportNivel(nombre), HttpStatus.OK);
    }
}
