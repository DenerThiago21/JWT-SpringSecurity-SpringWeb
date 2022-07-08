package com.dio.security.jwt.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.security.jwt.jwt.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
