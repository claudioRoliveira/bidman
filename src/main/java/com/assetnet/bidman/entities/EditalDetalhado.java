package com.assetnet.bidman.entities;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tb_detalhes")
public class EditalDetalhado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	private String edital;
	private String edle;
	private int situacao;
	private boolean permitePF;
	private int tipo;
	private String unidade;
	private String orgao;
	private String cidade;
	@Setter(AccessLevel.NONE) private Instant dataInicioPropostas;
	@Setter(AccessLevel.NONE) private Instant dataFimPropostas;
	@Setter(AccessLevel.NONE) private Instant dataAberturaLances;
	@Setter(AccessLevel.NONE) private Instant dataClassificacao;
	private String formaContato;
	private String dadosPublicacao;
	private boolean mostrarColunaProposta;
	private int numeroRecursos;
	
	@OneToMany(mappedBy = "editalDetalhado")
	private List<Lote> lotes = new ArrayList<>();
	
	@Column(insertable = false, updatable = false)
	private SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
		
	public void setDataInicioPropostas(String dataInicio) {
	    
		try {
			Date date = sdf.parse(dataInicio);
			this.dataInicioPropostas= date.toInstant();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	    
	}
	
	public void setDataFimPropostas(String dataFim) {
		    
			try {
				Date date = sdf.parse(dataFim);
				this.dataFimPropostas= date.toInstant();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    
	}
	
	public void setDataClassificacao(String dataClassificacao) {
	    
		try {
			Date date = sdf.parse(dataClassificacao);
			this.dataClassificacao= date.toInstant();
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
