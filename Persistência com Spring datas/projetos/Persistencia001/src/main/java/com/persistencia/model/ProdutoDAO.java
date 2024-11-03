package com.persistencia.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDAO 
       extends JpaRepository<Produto, Integer>{

}
