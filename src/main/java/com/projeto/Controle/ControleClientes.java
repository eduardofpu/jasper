package com.projeto.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.Entity.Clientes;
import com.projeto.Repositorio.RepositorioBairro;
import com.projeto.Repositorio.RepositorioCidade;
import com.projeto.Repositorio.RepositorioCliente;
import com.projeto.Repositorio.RepositorioEstado;

@Controller
public class ControleClientes {

	@Autowired
	RepositorioCliente repositorioCliente;
	@Autowired
	RepositorioBairro repositorioBairro;

	@Autowired
	RepositorioCidade repositorioCidade;

	@Autowired
	RepositorioEstado repositorioEstado;

	@RequestMapping(value = "/cliente")
	public String listarClientes(Clientes clientes, Model model) {
		model.addAttribute("clientes", repositorioCliente.findAll());
		model.addAttribute("bairros", repositorioBairro.findAllOrderByNome());
		model.addAttribute("cidades", repositorioCidade.findAllOrderByNome());
		model.addAttribute("estados", repositorioEstado.findAllOrderByNome());

		if (clientes.getIdCliente() != null) {
			model.addAttribute("cliente",
					repositorioCliente.findOne(clientes.getIdCliente()));
		} else {

			model.addAttribute("cliente", new Clientes());
		}

		return "cliente";
	}

	@RequestMapping(value = "/cliente/salve")
	public String salvarCliente(Clientes clientes) {
		repositorioCliente.save(clientes);
		return "redirect:/cliente";
	}

	@RequestMapping(value = "/cliente/del")
	public String deletarCliente(Clientes clientes) {
		repositorioCliente.delete(clientes);
		return "redirect:/cliente";
	}

}
