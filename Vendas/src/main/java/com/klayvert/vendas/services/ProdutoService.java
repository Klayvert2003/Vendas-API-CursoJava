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
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
}
