package com.projeto.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.projeto.Entity.Cidade;

public interface RepositorioCidade extends CrudRepository<Cidade,Long>{
	@Query("select u from Cidade u where u.nomeCidade  like ? ")
	List<Cidade> findByCidadeNome(String nomeCidade);
	
	
	
	@Query("from Cidade order by nomeCidade")
	public List<Cidade> findAllOrderByNome();
	
	
	
	@Query("from Cidade")
	public List<Cidade> findAllCidade();
	
	
	

}
