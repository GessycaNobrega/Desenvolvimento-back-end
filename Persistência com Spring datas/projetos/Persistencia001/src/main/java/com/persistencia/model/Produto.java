package com.persistencia.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id
	public Integer codigo;
	public String nome;
	public Integer quantidade;
	
	public Produto() {}
	public Produto(Integer codigo, String nome, Integer quantidade) {
		this.codigo = codigo;
		this.nome = nome;
		this.quantidade = quantidade;
	}
}
