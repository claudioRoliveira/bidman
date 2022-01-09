package com.assetnet.bidman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assetnet.bidman.entities.Edital;
import com.assetnet.bidman.repositories.EditalRepository;

@RestController
@RequestMapping(value = "/disponiveis")
public class EditalController {
	
	@Autowired
	private EditalRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Edital>> findAll() {
		List<Edital> result = repository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/paginado")
	public ResponseEntity<Page<Edital>> findAll(Pageable pageable) {
		Page<Edital> result = repository.findAll(pageable);
		return ResponseEntity.ok(result);
	}

}
