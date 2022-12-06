package com.CRUDconJPA.JoyeriaLasPerlas.controller;

import com.CRUDconJPA.JoyeriaLasPerlas.dto.JoyaDto;
import com.CRUDconJPA.JoyeriaLasPerlas.service.JoyaServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
	
	// Dependencias
	JoyaServiceImp joyaServiceImp;
	
	public JoyaController(JoyaServiceImp joyaServiceImp) {
		this.joyaServiceImp = joyaServiceImp;
	}
	
	// Guardar
	@PostMapping("/new")
	public ResponseEntity<?> save(@RequestBody @Valid JoyaDto joyaDto) {
		JoyaDto joyaDtoSaved = joyaServiceImp.saveAndFlush(joyaDto);
		return ResponseEntity
						.ok()
						.body("El número identificatorio es " + joyaDtoSaved.getId());
	}
	
	// Buscar todos
	@GetMapping
	public ResponseEntity<List<JoyaDto>> findAll() {
		List<JoyaDto> joyaDtoList = joyaServiceImp.findAll();
		return ResponseEntity.ok().body(joyaDtoList);
	}
	
	// Buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<JoyaDto> findById(@PathVariable @NotNull Long id) {
		JoyaDto joyaDto = joyaServiceImp.findById(id);
		return ResponseEntity.ok().body(joyaDto);
	}
	
	// Eliminar por id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable @NotNull Long id) {
		joyaServiceImp.deleteById(id);
		return ResponseEntity.ok().body("El id " + id + " fue eliminado con éxito");
	}
	
	// Modificar
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody JoyaDto joyaDto) {
		joyaDto.setId(id);
		joyaServiceImp.update(joyaDto);
		return ResponseEntity.ok().body(joyaDto);
	}
}
