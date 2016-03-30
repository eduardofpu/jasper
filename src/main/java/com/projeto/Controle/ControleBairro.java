package com.projeto.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.Entity.Bairro;
import com.projeto.Repositorio.RepositorioBairro;
import com.projeto.Repositorio.RepositorioCidade;

@Controller
public class ControleBairro {
	
	@Autowired
	RepositorioBairro repositorioBairro;
	
	@Autowired
	RepositorioCidade repositorioCidade;
	
	@RequestMapping(value="/bairro")
	public String listarBairro(Bairro bairro,Model model){
		model.addAttribute("bairros", repositorioBairro.findAll());
		model.addAttribute("cidades",repositorioCidade.findAllOrderByNome());
		
		if(bairro.getIdBairro()!=null){
			model.addAttribute("b", repositorioBairro.findOne(bairro.getIdBairro()));
		}else{
			
			model.addAttribute("b", new Bairro());
			
		}
		
		return "bairro";
	}
	@RequestMapping(value="/bairro/salve")
	public String salvarBairro(Bairro bairro){
		repositorioBairro.save(bairro);
		return "redirect:/bairro";
	}
	@RequestMapping(value="/bairro/del")
	public String deletarBairro(Bairro bairro){
		
		repositorioBairro.delete(bairro);
		return "redirect:/bairro";
	}

}
