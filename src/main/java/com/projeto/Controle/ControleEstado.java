package com.projeto.Controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.Entity.Estado;
import com.projeto.Repositorio.RepositorioEstado;

@Controller
public class ControleEstado {
	
	@Autowired
	RepositorioEstado repositorioEstado;
	
	@RequestMapping(value="/")
    public  String ListarEstado(Estado estado ,Model model){
		
		model.addAttribute("estados",repositorioEstado.findAll());
		
		if(estado.getIdEstado()!=null){
			
			model.addAttribute("estado",repositorioEstado.findOne(estado.getIdEstado()));
			
		}else{
			model.addAttribute("estado",new Estado());
		}	
		
		return "index";
		
		
	}
	
	@RequestMapping(value="/estado/salve")	
	public String salvarEstados(Estado estado){
		repositorioEstado.save(estado);		
		return "redirect:/";
	}
	
	@RequestMapping(value="/estado/del")	
	public String deletarEstados(Estado estado){
		repositorioEstado.delete(estado);
		return "redirect:/";
	}

}
