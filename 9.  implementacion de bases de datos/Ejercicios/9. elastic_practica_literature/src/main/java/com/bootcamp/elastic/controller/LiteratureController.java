package com.bootcamp.elastic.controller;

import com.bootcamp.elastic.dto.DateDTO;
import com.bootcamp.elastic.dto.LiteratureDTO;
import com.bootcamp.elastic.service.LiteratureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/literature")
public class LiteratureController {

    // DEPENDENCIES ---------------------------------------- //
   final LiteratureService literatureService;
    
    public LiteratureController(LiteratureService literatureService) {
        this.literatureService = literatureService;
    }
    
    // CRUD ---------------------------------------- //
    @GetMapping
    public ResponseEntity<?> getLiterature () {
        return new ResponseEntity<>(literatureService.findAll(), OK);
    }

    @PostMapping
    public ResponseEntity<?> saveLiterature ( @RequestBody List<LiteratureDTO> literatureDTOList ) {
      literatureService.saveAll(literatureDTOList);
      return ResponseEntity.ok(CREATED);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllLiterature (@RequestBody List<LiteratureDTO> literatureDTOList) {
        literatureService.deleteAll(literatureDTOList);
        return ResponseEntity.ok("Elementos eliminados con éxito");
    }
  
  // OTHERS ----------------------------------- //
  @GetMapping("/one")
  public ResponseEntity<?> getLiteratureByAuthorIs(@RequestParam String author ){
      List<LiteratureDTO> literatureDTOList = literatureService.getLiteratureByAuthorIs(author);
      return ResponseEntity.ok().body(literatureDTOList);
    }
    
    @GetMapping("/two")
  public ResponseEntity<?> getLiteratureByTitleIn(@RequestBody List<String> keywords){
      List<LiteratureDTO> literatureDTOList = literatureService.getLiteratureByTitleIn(keywords);
    return ResponseEntity.ok(literatureDTOList);
    }
    
    @GetMapping("/three")
  public ResponseEntity<?> getLiteratureByCantPagesGreaterThan(@RequestParam Integer cantPages){
      List<LiteratureDTO> literatureDTOList = literatureService.getLiteratureByCantPagesGreaterThan(cantPages);
    return ResponseEntity.ok().body(literatureDTOList);
    }
  
    @GetMapping("/four")
  public ResponseEntity<?> getLiteratureByFirstPostAfterOrderByFirstPost(@RequestBody DateDTO date){
     List<LiteratureDTO> literatureDTOList =  literatureService.getLiteratureByFirstPostAfterOrderByFirstPost(date);
      return ResponseEntity.ok().body(literatureDTOList);
    }
    
    @GetMapping("/four2")
    public ResponseEntity<?> getLiteratureByFirstPostBeforeOrderByFirstPost(@RequestBody DateDTO date){
      List<LiteratureDTO> literatureDTOList =  literatureService.getLiteratureByFirstPostBeforeOrderByFirstPost(date);
      return ResponseEntity.ok().body(literatureDTOList);
    }
    
    @GetMapping("/five")
  public ResponseEntity<?> getLiteratureByEditorialIs(@RequestParam String editorial){
      List<LiteratureDTO> literatureDTOList = literatureService.getLiteratureByEditorialIs(editorial);
      return ResponseEntity.ok().body(literatureDTOList);
    }
}
