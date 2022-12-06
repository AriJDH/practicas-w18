package com.example.joyeria.controller;

import com.example.joyeria.model.Joya;
import com.example.joyeria.service.IJoyaService;
import com.example.joyeria.service.JoyaServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private IJoyaService joyaService;

    public JoyaController(JoyaServiceImp serv){
        this.joyaService = serv;
    }

    @PostMapping("/new")
    public String createJoya(@RequestBody Joya joya){
        joyaService.saveStuden(joya);
        return "Jewerly save ok";
    }

    @GetMapping()
    public List<Joya> getJoyas(){
        return joyaService.getJoyas();
    }

    @PostMapping("/update/{id}")
    public Joya editJoya(@PathVariable Long id,
                         @RequestBody Joya joya){

        return joyaService.updateJoya(id, joya);
    }

    @PostMapping("delete/{id}")
    public String deleteJoya(@PathVariable Long id){
        joyaService.deleteJoya(id);
        return "Joya deleted ok";
    }

}
