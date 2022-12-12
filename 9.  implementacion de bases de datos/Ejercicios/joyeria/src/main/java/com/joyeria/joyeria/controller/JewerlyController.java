package com.joyeria.joyeria.controller;

import com.joyeria.joyeria.exception.JewerlyException;
import com.joyeria.joyeria.model.Jewerly;
import com.joyeria.joyeria.service.IJewerlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    private final IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @PostMapping("")
    public ResponseEntity<?> save (@RequestBody Jewerly jewerly){
        Jewerly j = jewerlyService.save(jewerly);
        return ResponseEntity.ok().body("Jewerly Id " + j.getId());
    }

    @GetMapping("/onSale")
    public ResponseEntity<List<Jewerly>> getJewerliesOnSale() {
        return ResponseEntity.ok().body(jewerlyService.getAllJewerliesOnSale());
    }

    @GetMapping()
    public ResponseEntity<List<Jewerly>> getAll() {
        return ResponseEntity.ok().body(jewerlyService.getAll());
    }
/*    @ResponseBody
    public List<Jewerly> getAll() {
        return jewerlyService.getAll();
    }*/


    @GetMapping("/{id}")
    public ResponseEntity<Jewerly> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(jewerlyService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jewerly> update(@PathVariable Long id, @RequestBody Jewerly jewerly){
        return ResponseEntity.ok().body(jewerlyService.update(id, jewerly));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLogicallyById(@PathVariable Long id) throws JewerlyException {
        jewerlyService.deleteLogicallyById(id);
        return ResponseEntity.ok().body("Jewerly id " + id + "was remove from list on sale");
    }
}

