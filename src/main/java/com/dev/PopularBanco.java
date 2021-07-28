package com.dev;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dev.model.Funcionario;
import com.dev.repository.FuncionarioRepository;

@Component
@Transactional
public class PopularBanco implements CommandLineRunner{

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Funcionario f1 = new Funcionario("Tasso Chaves");
		f1.setDataNascimento(LocalDate.now());
		f1.setTelefone("98991415719");
		f1.setEmail("tchaves@gmail.com");
		
		Funcionario f2 = new Funcionario("Davi");
		f2.setDataNascimento(LocalDate.now());
		f2.setTelefone("(98)9999999");
		f2.setEmail("davi@gmail.com");
		
		funcionarioRepository.save(f1);
		funcionarioRepository.save(f2);
	}

}
