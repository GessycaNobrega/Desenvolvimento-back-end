package com.persistencia.model;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	public Integer id;
	public String isbn;
	public String nome;
	public Integer ano;
	public String editora;
	public List<String> autores = new ArrayList<>();
}

