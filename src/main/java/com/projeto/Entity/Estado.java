package com.projeto.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEstado;
	private String nomeEstado;
	private String sigla;

	
	public Estado() {
		// TODO Auto-generated constructor stub
	}


	


	public Long getIdEstado() {
		return idEstado;
	}





	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}





	public String getNomeEstado() {
		return nomeEstado;
	}


	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}
