package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.model.Funcionario;
import com.dev.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("/rh/funcionarios")
	public String funcionario(Model model) {
		model.addAttribute("listaFuncionarios", funcionarioRepository.findAll());
		return "rh/funcionarios/index";
	}
	
	@GetMapping("/rh/funcionario/novo")
	public String novoFuncionario(@ModelAttribute("funcionario") Funcionario funcionario) {
		return "rh/funcionarios/formulario";
	}
	
	@PostMapping("/rh/funcionario/salvar")
	public String salvarFuncionario(@ModelAttribute("funcionario") Funcionario funcionario){
		
		funcionarioRepository.save(funcionario);
		
		return "redirect:/rh/funcionarios";
		
	}

}
