package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.Produto;
import com.klayvert.vendas.domain.repository.ProdutoRepository;
import com.klayvert.vendas.rest.dtos.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

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
}
