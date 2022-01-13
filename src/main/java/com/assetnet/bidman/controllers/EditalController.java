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

import com.assetnet.bidman.entities.Edital;
import com.assetnet.bidman.services.EditalService;

@RestController
@RequestMapping(value = "/disponiveis")
public class EditalController {
	
	
	private EditalService service;
	
		
	@GetMapping
	public ResponseEntity<Page<Edital>> findAll(Pageable pageable) {
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping(value = "/edle")
	public ResponseEntity<Edital> findByEdle(@RequestParam(defaultValue = "") String edle) {
		return ResponseEntity.ok(service.findByEdle(edle));
	}
	
	@GetMapping(value = "/update")
	public ResponseEntity<String> updateList() {
		return ResponseEntity.ok(service.updateList());
	}

}
