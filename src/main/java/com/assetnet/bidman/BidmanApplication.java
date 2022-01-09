package com.assetnet.bidman;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.assetnet.bidman.entities.EditalDetalhado;
import com.assetnet.bidman.repositories.EditalDetalhadoRepository;

@SpringBootApplication
public class BidmanApplication {

	private EditalDetalhadoRepository editaldetailRepo;
	
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
			//log.error(editalAtual.toString());
			System.out.println(editalAtual.toString());
			//editaldetailRepo.save(editalAtual);
		};
	}

}
