package com.persistencia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.persistencia.controller.GerenciadorProduto;
import com.persistencia.model.Produto;

@SpringBootApplication
public class Persistencia001Application {

	@Autowired
	GerenciadorProduto controle;
	
	public static void main(String[] args) {
		SpringApplication.run(Persistencia001Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("<<< Verificação da base de dados >>>");
			controle.add(new Produto(101,"ABACATE",2000));
			for(Produto p: controle.findAll()) {
				System.out.println(p.nome);
			}
		};
	}
}

