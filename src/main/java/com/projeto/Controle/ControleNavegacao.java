package com.projeto.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.Repositorio.RepositorioCidade;
import com.projeto.Repositorio.RepositorioCliente;

@Controller
public class ControleNavegacao {
	@Autowired
	RepositorioCidade repositorioCidade;

	@RequestMapping(value = "/pesquisaCidade")
	public String pesquisaCidade(Model model, String nomeCidade) {
		model.addAttribute("cidadePesquisa",
				repositorioCidade.findByCidadeNome("%"+nomeCidade+"%"));
				
		return "pesquisaCidade";
		
	}

	@Autowired
	RepositorioCliente repositorioCliente;

	@RequestMapping(value = "/pesquisaCliente")
	public String pesquisaCliente(Model model, String nomeCliente) {

		model.addAttribute("clientePesquisa",
				repositorioCliente.findByNomeCliente("%"+nomeCliente+"%"));
		return "pesquisaCliente";
		
	}

}
