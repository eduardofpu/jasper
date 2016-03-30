package com.projeto.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCidade;
	private String nomeCidade;
	@ManyToOne
	private Estado estado;
	
	
	
	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public Cidade() {
		// TODO Auto-generated constructor stub
	}


	

	public Long getIdCidade() {
		return idCidade;
	}


	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}


	public String getNomeCidade() {
		return nomeCidade;
	}


	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	
}
