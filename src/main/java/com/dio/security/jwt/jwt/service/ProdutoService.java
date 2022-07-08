package com.dio.security.jwt.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.security.jwt.jwt.model.Produto;
import com.dio.security.jwt.jwt.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public void createProduto(Produto produto) {
        repository.save(produto);
    }

    public List<Produto> findAllProdutos() {
        return repository.findAll();
    }
}
