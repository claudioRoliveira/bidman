package com.assetnet.bidman.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Situacao {
	
	private String situacao;
	private Boolean editaisEstaoLimitados;
	private List<Edital> lista;

}
