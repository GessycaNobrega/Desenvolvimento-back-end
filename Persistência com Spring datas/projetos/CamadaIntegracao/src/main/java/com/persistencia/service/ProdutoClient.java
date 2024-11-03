package com.persistencia.service;

import java.util.ArrayList;
import java.util.List;

import com.persistencia.model.Movimento;
import com.persistencia.model.MovimentoVO;
import com.persistencia.model.Produto;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ProdutoClient {
	private Retrofit retrofit;
	private IProdutoService produtoService;
	private IMovimentoService movimentoService;
	
	public ProdutoClient() {
		retrofit = new Retrofit.Builder()
			    .baseUrl("http://localhost:8080")
			    .addConverterFactory(JacksonConverterFactory.create())
			    .build();
		produtoService = retrofit.create(IProdutoService.class);
		movimentoService = retrofit.create(IMovimentoService.class);
	}
	
	public List<Produto> obterProdutos() {
		try {
		    return produtoService.obterTodos().execute().body();
		}catch(Exception e) {
			return new ArrayList<Produto>();
		}
	}
	
	public Produto obterProduto(Integer codigo) {
		try {
		    return produtoService.obterProduto(codigo).execute().body();
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean incluirProduto(Produto produto) {
		try {
		    produtoService.incluir(produto).execute();
		    return true;
		}catch(Exception e) {
			return false;
		}	
	}

	public boolean alterarProduto(Integer codigo, Produto produto) {
		try {
		    produtoService.alterar(codigo,produto).execute();
		    return true;
		}catch(Exception e) {
			return false;
		}	
	}

	public boolean excluirProduto(Integer codigo) {
		try {
		    produtoService.remover(codigo).execute();
		    return true;
		}catch(Exception e) {
			return false;
		}	
	}
	
	public List<Movimento> obterMovimentos(Integer codProduto) {
		try {
			return movimentoService.obterMovimentos(codProduto).execute().body();
		}catch(Exception e) {
			return new ArrayList<Movimento>();
		}
	}
	
	public MovimentoVO incluirMovimento(MovimentoVO dados) {
		try {
		    return movimentoService.incluirMovimento(dados).execute().body();
		}catch(Exception e) {
			dados.sucesso = false;
			return dados;
		}		
	}

	public MovimentoVO excluirMovimento(Integer codProduto,Integer id) {
		try {
		    return movimentoService.excluirMovimento(codProduto,id).execute().body();
		}catch(Exception e) {
			MovimentoVO aux = new MovimentoVO();
			aux.codigo = 0;
			aux.sucesso = false;
			return aux;
		}		
	}
}
