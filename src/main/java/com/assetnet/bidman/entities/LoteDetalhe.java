package com.assetnet.bidman.entities;

import java.io.Serializable;


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
public class LoteDetalhe implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

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
	
}
