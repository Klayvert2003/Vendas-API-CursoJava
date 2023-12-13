package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.rest.dtos.ProdutoDTO;
import com.klayvert.vendas.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    @GetMapping("/find_all")
    public List<ProdutoDTO> findAllProducts(){
        return this.produtoService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO saveProducts(@RequestBody @Validated ProdutoDTO produtoDTO){
        return this.produtoService.save(produtoDTO);
    }
}
