package com.assetnet.bidman.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
@Table(name = "tb_lote")
public class Lote implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int loleNrSq;
	private int nrAtribuido;
	private String tipo;
	private int situacaoLote;
	private double valorMinimo;
	private boolean possuiImagens;
	private boolean destaque;
	private boolean permitePF;
	private boolean permiteEmitirOrientacoesGru;
	private boolean permiteEmitirDarf;
	private boolean permiteEmitirDarfSinalComplemento;
	private boolean permiteEmitirDarfLaudo;
	private boolean permiteVisualizarOpcoesProposta;
	private boolean permiteVerSalaDisputa;
	private boolean permiteVisualizarOpcoesRedesSocial;
	
	@OneToMany(mappedBy = "lote")
	private List<ItensDetalhesLote> itensDetalhesLote;
	
	@OneToMany(mappedBy = "lote")
	private List<Imagem> imagens= new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "editaldetalhado_id")
	private EditalDetalhado editalDetalhado;
        
}
