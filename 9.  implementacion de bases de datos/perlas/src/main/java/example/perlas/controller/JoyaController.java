package example.perlas.controller;

import example.perlas.model.Joya;
import example.perlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping("/jewerly/new")
    public String saveJoya (@RequestBody Joya joya) {

        return joyaServ.saveJoya(joya);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {

        return joyaServ.getJoya();
    }


    @PutMapping("/jewerly/delete/{id}")
    public void deleteJoya (@PathVariable Long id) {

        System.out.println("Joya eliminada");
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public String editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {

        return joyaServ.editJoya(id_modificar, joya);
    }

}

