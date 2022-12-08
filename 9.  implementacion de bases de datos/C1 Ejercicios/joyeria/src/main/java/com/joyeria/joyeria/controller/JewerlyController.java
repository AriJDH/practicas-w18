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
        return ResponseEntity.ok().body("Jewerly Id" + j.getId());
    }


    @GetMapping("/onSale")
    public ResponseEntity<List<Jewerly>> getJewerliesOnSale() {
        List<Jewerly> jewerlyList = jewerlyService.getAllJewerliesOnSale();
        return ResponseEntity.ok().body(jewerlyList);
    }

    @GetMapping()
    public ResponseEntity<List<Jewerly>> getAll() {
        List<Jewerly> jewerlyList = jewerlyService.getAll();
        return ResponseEntity.ok().body(jewerlyList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Jewerly> findById(@PathVariable Long id){
        Jewerly j = jewerlyService.findById(id);
        return ResponseEntity.ok().body(j);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jewerly> update(@PathVariable Long id, @RequestBody Jewerly jewerly){
        Jewerly j = jewerlyService.update(id, jewerly);
        return ResponseEntity.ok().body(j);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLogicallyById(@PathVariable Long id) throws JewerlyException {
        jewerlyService.deleteLogicallyById(id);
        return ResponseEntity.ok().body("Jewerly id " + id + "was remove from list on sale");
    }
}

