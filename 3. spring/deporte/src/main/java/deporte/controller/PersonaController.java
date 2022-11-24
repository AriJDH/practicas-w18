package deporte.controller;

import com.personadeporte.PersonaDeporte.dto.req.PersonaReqDTO;
import com.personadeporte.PersonaDeporte.dto.res.PersonaResDTO;
import com.personadeporte.PersonaDeporte.service.PersonaService;
import deporte.dto.req.PersonaReqDTO;
import deporte.service.PersonaService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonaController {

    private PersonaService personaService = new PersonaService();

    @PostMapping("/crearPersona")
    public ResponseEntity<String> crearPersona(@RequestBody PersonaReqDTO personaReqDTO){
        personaService.crearPersona(personaReqDTO);
        return new ResponseEntity<>("Persona creada", HttpStatus.CREATED);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaResDTO>> findSportsPersons(){
        return ResponseEntity.ok(personaService.findSportsPersons());
    }
}