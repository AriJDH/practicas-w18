package com.mercadolibre.Las.Perlas.controller;

import com.mercadolibre.Las.Perlas.entity.Joya;
import com.mercadolibre.Las.Perlas.service.iJoyaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.jar.JarOutputStream;

@RestController
public class JoyaController {
    @Autowired
    iJoyaService joyaService;

    @PostMapping("/jewelry/new")
    public Joya createJoya(@RequestBody Joya joya){
        //Joya joyaNueva = joyaService.findJoya(joya.getNro_identificatorio());
        if (joya.getVentaONo())
            return joyaService.saveJoya(joya);
        return joya;
    }

    @GetMapping("/jewelry")
    public List<Joya> getAll(){
        List<Joya> joyas = joyaService.getJoyas();
        return joyas;
    }

    @DeleteMapping("/jewelry/delete/{id}")
    public String deleteJoya(@PathVariable Long id){
        Joya joya = joyaService.findJoya(id);
        if (joya.getVentaONo()) {
            joyaService.deleteJoya(id);
            return "joya eliminada correctamente";
        }else {
            return "no se puede eliminar porque no esta a la venta";
        }
    }

    @PostMapping("/jewelry/update/{id}")
    public ResponseEntity<Joya> updatejoya(@RequestBody Joya joya,  @PathVariable Long id){
        Joya joyaEdit =joyaService.findJoya(id);
        joyaEdit.setNombre(joya.getNombre());
        joyaEdit.setMaterial(joya.getMaterial());
        joyaEdit.setPeso(joya.getPeso());
        joyaEdit.setVentaONo(joya.getVentaONo());
        joyaEdit.setPosee_piedra(joya.getPosee_piedra());
        joyaEdit.setParticularidad(joya.getParticularidad());

        joyaService.saveJoya(joyaEdit);

        return new ResponseEntity<>(joyaEdit, HttpStatus.OK);
    }

}
