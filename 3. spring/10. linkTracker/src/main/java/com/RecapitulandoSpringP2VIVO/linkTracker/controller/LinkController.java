package com.RecapitulandoSpringP2VIVO.linkTracker.controller;

import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDto;
import com.RecapitulandoSpringP2VIVO.linkTracker.dto.LinkDtoRes;
import com.RecapitulandoSpringP2VIVO.linkTracker.service.ILinkService;
import com.RecapitulandoSpringP2VIVO.linkTracker.service.LinkService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class LinkController {
	
	private final ILinkService linkService;
	
	public LinkController(LinkService linkService) {
		this.linkService = linkService;
	}
	
	@PostMapping
	public ResponseEntity<?> addLink(@RequestBody LinkDto linkDTO) {
		LinkDtoRes res = linkService.addLink(linkDTO);
		return ResponseEntity.ok().body(res);
	}
	
	@GetMapping("/{linkId}") // TODO
	public ResponseEntity<?> redirectURL(@PathVariable Integer id) {
		return ResponseEntity
						.badRequest()
						.body(new ExecutionControl.NotImplementedException("Método sin implementar"));
	}
	
	@GetMapping("/metrics/{linkId}") // TODO
	public ResponseEntity<?> getMetrics(@PathVariable Integer linkId) {
		return ResponseEntity
						.badRequest()
						.body(new ExecutionControl.NotImplementedException("Método sin implementar"));
	}
	
	@PostMapping("/invalidate/{linkId}") // TODO
	public ResponseEntity<?> invalidate(@PathVariable Integer linkId) {
		return ResponseEntity
						.badRequest()
						.body(new ExecutionControl.NotImplementedException("Método sin implementar"));
	}
	
}
