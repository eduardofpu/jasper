package com.projeto.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Bairro {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBairro;
	private String nomeBairro;
	
	@ManyToOne
	private Cidade cidade;
	
	public Long getIdBairro() {
		return idBairro;
	}
	public void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}
	public String getNomeBairro() {
		return nomeBairro;
	}
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
	

}
