package com.persistencia.service;

import java.util.List;

import com.persistencia.model.Produto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IProdutoService {
	@GET("produto")
	Call<List<Produto>> obterTodos();
	@GET("produto/{codigo}")
	Call<Produto> obterProduto(@Path(value="codigo") Integer codigo);
	@POST("produto")
	Call<Void> incluir(@Body Produto produto);
	@PUT("produto/{codigo}")
	Call<Void> alterar(@Path(value="codigo") Integer codigo, @Body Produto produto);
	@DELETE("produto/{codigo}")
	Call<Void> remover(@Path(value="codigo") Integer codigo);	
}
