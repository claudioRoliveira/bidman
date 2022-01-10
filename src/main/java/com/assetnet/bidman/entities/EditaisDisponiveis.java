package com.assetnet.bidman.entities;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EditaisDisponiveis {

	private String agora;
	private List<Situacao> situacoes;
	private String unidadeInvalida;
	

}
