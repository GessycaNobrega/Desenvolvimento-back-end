package com.persistencia.service;

import java.util.ArrayList;
import java.util.List;

import com.persistencia.model.Livro;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LivroClient {
	private Retrofit retrofit;
	private ILivroService livroService;
	
	public LivroClient() {
		retrofit = new Retrofit.Builder()
			    .baseUrl("http://localhost:8081")
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();
		livroService = retrofit.create(ILivroService.class);
	}
	
	public List<Livro> obterLivros() {
		try {
		    return livroService.obterTodos().execute().body();
		}catch(Exception e) {
			return new ArrayList<Livro>();
		}
	}
	
	public boolean incluirLivro(Livro livro) {
		try {
		    livroService.incluir(livro).execute();
		    return true;
		}catch(Exception e) {
			return false;
		}	
	}

	public boolean excluirLivro(Integer id) {
		try {
		    livroService.remover(id).execute();
		    return true;
		}catch(Exception e) {
			return false;
		}	
	}

}
