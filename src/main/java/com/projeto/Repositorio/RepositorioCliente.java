package com.projeto.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.projeto.Entity.Clientes;

public interface RepositorioCliente extends CrudRepository<Clientes, Long>{

	@Query("select u from Clientes u where u.nomeCliente like ?")
	List<Clientes> findByNomeCliente(String nomeCliente);
	
}
