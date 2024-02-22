package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.Produto;
import com.klayvert.vendas.domain.repository.ProdutoRepository;
import com.klayvert.vendas.rest.dtos.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoDTO> findAll(){
        return this.produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::toDto)
                .collect(Collectors.toList());
    }

    public ProdutoDTO save(ProdutoDTO dto){
        Produto produto = ProdutoDTO.toObj(dto);
        return ProdutoDTO.toDto(produtoRepository.save(produto));
    }

    public void delete(Long id){
        this.produtoRepository.delete(this.findById(id));
    }

    public ProdutoDTO update(ProdutoDTO dto){
        Produto produto = ProdutoDTO.toObj(dto);
        return ProdutoDTO.toDto(produtoRepository.save(produto));
    }

    public Produto findById(Long id){
        return this.produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    public List<Produto> findByParam(Produto produto){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Produto> example = Example.of(produto, matcher);
        return this.produtoRepository.findAll(example);
    }
}
