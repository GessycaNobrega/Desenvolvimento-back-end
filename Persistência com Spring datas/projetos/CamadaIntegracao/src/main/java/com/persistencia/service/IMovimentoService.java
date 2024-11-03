package com.persistencia.service;

import java.util.List;

import com.persistencia.model.Movimento;
import com.persistencia.model.MovimentoVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IMovimentoService {
  @GET("/movimento/{cod_prod}")
  Call<List<Movimento>> obterMovimentos( 
                        @Path(value="cod_prod") Integer codigo);

  @POST("/movimento")
  Call<MovimentoVO> incluirMovimento(@Body MovimentoVO dados);

  @DELETE("/movimento/{cod_prod}/{id_mov}")
  Call<MovimentoVO> excluirMovimento(
                    @Path(value="cod_prod") Integer codigo,
                    @Path(value="id_mov") Integer id);
}

