package com.assetnet.bidman.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.assetnet.bidman.entities.Edital;
import com.assetnet.bidman.repositories.EditalDetalhadoRepository;
import com.assetnet.bidman.repositories.EditalRepository;
import com.assetnet.bidman.repositories.ImagemRepository;
import com.assetnet.bidman.repositories.LoteRepository;


public class EditalService {
	
	@Autowired
	private EditalDetalhadoRepository editaldetailRepo;
	
	@Autowired
	private ImagemRepository imagemRepo;
	
	@Autowired
	private LoteRepository loteRepo;
	
	@Autowired
	private EditalRepository repository;
	
	
	public Page<Edital> findAll(Pageable pageable) {
		return repository.findAll(pageable);
		
	}
	
	public Edital findByEdle(String edle) {
		return repository.findByEdle(edle);
	}
	
	public String updateList() {
		return null;
		
//		RestTemplate restTemplate = new RestTemplateBuilder().build();
//		
//		EditaisDisponiveis disponiveis = restTemplate.getForObject("http://www25.receita.fazenda.gov.br/sle-sociedade/api/editais-disponiveis", EditaisDisponiveis.class);
//		
//		for(Situacao status : disponiveis.getSituacoes()) {
//			for(Edital edital : status.getLista()) {
//				if(repository.findByEdle(edital.getEdle()) == null) {
//					repository.save(edital);
//					
//					EditalDetalhado editalAtual = restTemplate.getForObject("http://www25.receita.fazenda.gov.br/sle-sociedade/api/edital/" + edital.getEdle(), EditalDetalhado.class);
//					editaldetailRepo.save(editalAtual);
//					for(Lote lote: editalAtual.getLotes()) {
//						lote.setEditalDetalhado(editalAtual);
//					}
//					loteRepo.saveAll(editalAtual.getLotes());
//					for(Lote lot: editalAtual.getLotes()) {
//						for(Imagem figura : lot.getImagens()) {
//							figura.setLote(lot);
//						}
//						imagemRepo.saveAll(lot.getImagens());
//					}
//				}
//				
//			}
//			
//		}
//		return "done";
	} 

}
