package meli.bootcamp.joyerialasperlas.controller;

import meli.bootcamp.joyerialasperlas.dto.req.JewelryDtoReq;
import meli.bootcamp.joyerialasperlas.dto.res.JewelrySavedDto;
import meli.bootcamp.joyerialasperlas.entity.Jewelry;
import meli.bootcamp.joyerialasperlas.service.IJewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jewerly")
public class JewelryController {
    @Autowired
    IJewelryService jewelryService;

    @GetMapping("/")
    public List<Jewelry> getJewelry() {
        return jewelryService.getJewelry();
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJewelry(@RequestBody JewelryDtoReq jewelry) {
        JewelrySavedDto jewelrySavedDto = jewelryService.saveJewelry(jewelry);
        return ResponseEntity.status(HttpStatus.OK).body(jewelrySavedDto);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id) {
        jewelryService.deleteJewelry(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewelry(@PathVariable("id_modificar") Long id,
                                           @RequestBody JewelryDtoReq jewelry) {
        JewelrySavedDto jewelrySavedDto = jewelryService.updateJewelry(id, jewelry);
        return ResponseEntity.status(HttpStatus.OK).body(jewelrySavedDto);
    }
}
