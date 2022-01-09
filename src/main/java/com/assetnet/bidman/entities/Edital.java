package com.assetnet.bidman.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
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
@Entity
@Table(name = "tb_edital")
public class Edital implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	private String edital;
	private String edle;
	private int codigoSituacao;
	private boolean permitePF;
	private String tipo;
	private String uaNm;
	private String orgao;
	private String cidade;
	@Setter(AccessLevel.NONE) private Instant dataInicioPropostas;
	@Setter(AccessLevel.NONE) private Instant dataAberturaLances;
	private int lotes;
	
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	public void setDataInicioPropostas(String dataInicio) {
	    
		try {
			Date date = sdf.parse(dataInicio);
			this.dataInicioPropostas= date.toInstant();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	
	public void setDataAberturaLances(String dataAbertura) {
		    
		try {
			Date date = sdf.parse(dataAbertura);
			this.dataAberturaLances= date.toInstant();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		   
	}
	
	
}
