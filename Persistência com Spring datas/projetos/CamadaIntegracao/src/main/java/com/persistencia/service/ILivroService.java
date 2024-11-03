package com.persistencia.service;

import java.util.List;

import com.persistencia.model.Livro;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ILivroService {
	  @GET("livro")
	  Call<List<Livro>> obterTodos();
	  @POST("livro")
	  Call<Void> incluir(@Body Livro livro);
	  @DELETE("livro/{id}")
	  Call<Void> remover(@Path("id") Integer id);	  
}
