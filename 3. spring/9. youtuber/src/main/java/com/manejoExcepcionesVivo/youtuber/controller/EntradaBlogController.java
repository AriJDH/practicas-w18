package com.manejoExcepcionesVivo.youtuber.controller;

import com.manejoExcepcionesVivo.youtuber.dto.EntradaBlogDTO;
import com.manejoExcepcionesVivo.youtuber.exception.IdDuplicadoException;
import com.manejoExcepcionesVivo.youtuber.service.EntradaBlogServiceImp;
import com.manejoExcepcionesVivo.youtuber.service.IEntradaBlogService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import java.util.List;

@RestController
public class EntradaBlogController {
	
	// Inyección de dependencias por constructor ----------------------------
	private final IEntradaBlogService entradaBlogService;
	
	public EntradaBlogController(EntradaBlogServiceImp entradaBlogServiceImp) {
		this.entradaBlogService = entradaBlogServiceImp;
	}
	
	// CRUD ------------------------------------------------------------------
	@PostMapping("/blog")
	public ResponseEntity<String> agregarEntrada(@RequestBody EntradaBlogDTO entradaBlogDto)
					throws IdDuplicadoException {
		Long id = entradaBlogService.agregar(entradaBlogDto);
		return new ResponseEntity<>("La entrada fue generada con el Id " + id,
						HttpStatus.CREATED);
	}
	
	@GetMapping("/blog/{id}")
	public ResponseEntity<EntradaBlogDTO> buscarPorId(@PathVariable("id") Long id) {
		EntradaBlogDTO entradaBlogDTO = entradaBlogService.buscarPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(entradaBlogDTO);
	}
	
	@GetMapping("/blogs")
	public ResponseEntity<List<EntradaBlogDTO>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(entradaBlogService.buscarTodos());
	}
}
