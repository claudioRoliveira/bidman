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

import com.assetnet.bidman.entities.EditaisDisponiveis;
import com.assetnet.bidman.entities.Edital;
import com.assetnet.bidman.entities.EditalDetalhado;
import com.assetnet.bidman.entities.Imagem;
import com.assetnet.bidman.entities.ItensDetalhesLote;
import com.assetnet.bidman.entities.Lote;
import com.assetnet.bidman.entities.Situacao;
import com.assetnet.bidman.repositories.EditalDetalhadoRepository;
import com.assetnet.bidman.repositories.EditalRepository;
import com.assetnet.bidman.repositories.ImagemRepository;
import com.assetnet.bidman.repositories.ItensDetalheLoteRepository;
import com.assetnet.bidman.repositories.LoteRepository;

@SpringBootApplication
public class BidmanApplication {

	@Autowired
	private EditalDetalhadoRepository editaldetailRepo;

	@Autowired
	private EditalRepository editalRepo;

	@Autowired
	private ImagemRepository imagemRepo;

	@Autowired
	private LoteRepository loteRepo;

	@Autowired
	private ItensDetalheLoteRepository detailRepo;

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

			EditaisDisponiveis disponiveis = restTemplate.getForObject(
					"http://www25.receita.fazenda.gov.br/sle-sociedade/api/editais-disponiveis",
					EditaisDisponiveis.class);

			for (Situacao status : disponiveis.getSituacoes()) {
				for (Edital edital : status.getLista()) {
					if (editalRepo.findByEdle(edital.getEdle()) == null) {
						editalRepo.save(edital);
						EditalDetalhado editalAtual = restTemplate.getForObject(
								"http://www25.receita.fazenda.gov.br/sle-sociedade/api/edital/" + edital.getEdle(),
								EditalDetalhado.class);

						editaldetailRepo.save(editalAtual);
						for (Lote lote : editalAtual.getLotes()) {
							lote.setEditalDetalhado(editalAtual);
						}
						loteRepo.saveAll(editalAtual.getLotes());
						for (Lote lot : editalAtual.getLotes()) {
							for (Imagem figura : lot.getImagens()) {
								figura.setLote(lot);
							}
							imagemRepo.saveAll(lot.getImagens());

							if (lot.getSituacaoLote() <= 10) {
								Lote loteAtual = restTemplate
										.getForObject("http://www25.receita.fazenda.gov.br/sle-sociedade/api/lote/"
												+ edital.getEdle() + "/" + lot.getNrAtribuido(), Lote.class);
								if (loteAtual.getItensDetalhesLote() != null) {
									for (ItensDetalhesLote detail : loteAtual.getItensDetalhesLote()) {
										detail.setLote(lot);
									}
									detailRepo.saveAll(loteAtual.getItensDetalhesLote());
								}
							}
						}
					}

				}

			}

		};
	}

}
