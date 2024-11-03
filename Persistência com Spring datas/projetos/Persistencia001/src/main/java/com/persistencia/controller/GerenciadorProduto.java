package com.persistencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.persistencia.model.Produto;
import com.persistencia.model.ProdutoDAO;

@Component
public class GerenciadorProduto {
   @Autowired
   private ProdutoDAO produtoDAO;
    
   @Transactional
   public void add(Produto produto){
      produtoDAO.save(produto);
   }
    
   @Transactional(readOnly = true)
   public List<Produto> findAll(){
      return produtoDAO.findAll();                
   }
}
