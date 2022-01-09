package com.assetnet.bidman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.assetnet.bidman.entities.EditalDetalhado;
import com.assetnet.bidman.entities.Imagem;
import com.assetnet.bidman.entities.Lote;
import com.assetnet.bidman.repositories.EditalDetalhadoRepository;
import com.assetnet.bidman.repositories.ImagemRepository;
import com.assetnet.bidman.repositories.LoteRepository;

@SpringBootApplication
public class BidmanApplication {

	@Autowired
	private EditalDetalhadoRepository editaldetailRepo;
	
	@Autowired
	private ImagemRepository imagemRepo;
	
	@Autowired
	private LoteRepository loteRepo;
	
	private static final Logger log = LoggerFactory.getLogger(BidmanApplication.class);

	public static void main(String[] args) {
		
		SpringApplication.run(BidmanApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		
		return args -> {
			EditalDetalhado editalAtual = restTemplate.getForObject("http://www25.receita.fazenda.gov.br/sle-sociedade/api/edital/717800/8/2021", EditalDetalhado.class);
			editaldetailRepo.save(editalAtual);
			
			for(Lote lote: editalAtual.getLotes()) {
				lote.setEditalDetalhado(editalAtual);
			}
			loteRepo.saveAll(editalAtual.getLotes());
			
			for(Lote lot: editalAtual.getLotes()) {
				for(Imagem figura : lot.getImagens()) {
					figura.setLote(lot);
				}
				imagemRepo.saveAll(lot.getImagens());
			}
			
		};
	}

}
