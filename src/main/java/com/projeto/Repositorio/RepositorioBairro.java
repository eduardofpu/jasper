package com.projeto.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projeto.Entity.Bairro;

public interface RepositorioBairro extends CrudRepository<Bairro, Long>{

	
	
	@Query("from Bairro order by nomeBairro")
	public List<Bairro> findAllOrderByNome();

}
