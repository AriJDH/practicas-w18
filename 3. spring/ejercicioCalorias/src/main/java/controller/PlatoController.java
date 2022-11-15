package PlatoController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {

    private IServicePlato iServicePlato;

    public PlatoController(IServicePlato iServicePlato) {
        this.iServicePlato = iServicePlato;
    }

    @GetMapping("/consultarPlato/{nombre}/{peso}")
    public ResponseEntity<PlatoDTO> consultarPlato(@PathVariable String nombre, @PathVariable Integer peso) {
        return new ResponseEntity<>(this.iServicePlato.consultarPlato(nombre, peso), HttpStatus.OK);
    }
}