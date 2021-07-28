package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
