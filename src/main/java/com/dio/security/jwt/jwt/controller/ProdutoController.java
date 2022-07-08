package com.dio.security.jwt.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.security.jwt.jwt.model.Produto;
import com.dio.security.jwt.jwt.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @PostMapping
    public void postProduto(@RequestBody Produto produto) {
        service.createProduto(produto);
    }

    @GetMapping
    public List<Produto> findAllProdutos() {
        return service.findAllProdutos();
    }
}
