package com.projeto.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.projeto.Entity.Estado;

public interface RepositorioEstado extends CrudRepository<Estado,Long>{

	@Query("from Estado order by nomeEstado")
	public List<Estado> findAllOrderByNome();
	
}
