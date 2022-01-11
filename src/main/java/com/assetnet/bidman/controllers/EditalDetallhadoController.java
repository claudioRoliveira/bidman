package com.assetnet.bidman.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assetnet.bidman.entities.EditalDetalhado;
import com.assetnet.bidman.repositories.EditalDetalhadoRepository;

@RestController
@RequestMapping(value = "/detalhes")
public class EditalDetallhadoController {
	
	@Autowired
	private EditalDetalhadoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<EditalDetalhado>> findAll() {
		List<EditalDetalhado> result = repository.findAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/paginado")
	public ResponseEntity<Page<EditalDetalhado>> findAll(Pageable pageable) {
		Page<EditalDetalhado> result = repository.findAll(pageable);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/edle")
	public ResponseEntity<EditalDetalhado> findByEdle(@RequestParam(defaultValue = "") String edle) {
		EditalDetalhado result = (EditalDetalhado) repository.findByEdle(edle);
		return ResponseEntity.ok(result);
	}

}
