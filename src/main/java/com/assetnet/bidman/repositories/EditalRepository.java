package com.assetnet.bidman.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assetnet.bidman.entities.Edital;


public interface EditalRepository extends JpaRepository<Edital, Long>{
	
	Edital findByEdle(String edle);

}
