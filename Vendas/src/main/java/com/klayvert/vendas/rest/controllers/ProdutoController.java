package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.domain.entities.Produto;
import com.klayvert.vendas.rest.dtos.ProdutoDTO;
import com.klayvert.vendas.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> findAllProducts(){
        return this.produtoService.findAll();
    }

    @GetMapping("find_by")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> findByParam(Produto param){
        return this.produtoService.findByParam(param);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO saveProducts(@RequestBody @Valid ProdutoDTO produtoDTO){
        return this.produtoService.save(produtoDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.produtoService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoDTO update(@RequestBody @Valid ProdutoDTO produtoDTO){
        return this.produtoService.update(produtoDTO);
    }
}
