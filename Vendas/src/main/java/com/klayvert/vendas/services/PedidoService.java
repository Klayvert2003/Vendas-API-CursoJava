package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.Pedido;
import com.klayvert.vendas.domain.repository.PedidoRepository;
import com.klayvert.vendas.rest.dtos.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoDTO> findAll(){
        return this.pedidoRepository.findAll()
                .stream()
                .map(PedidoDTO::toDto)
                .collect(Collectors.toList());
    }

    public PedidoDTO save(PedidoDTO dto){
        Pedido pedido = PedidoDTO.toObj(dto);

        return PedidoDTO.toDto(pedidoRepository.save(pedido));
    }

    public void delete(Long id){
        this.pedidoRepository.delete(this.findById(id));
    }

    public PedidoDTO update(PedidoDTO dto){
        Pedido pedido = PedidoDTO.toObj(dto);
        return PedidoDTO.toDto(pedidoRepository.save(pedido));
    }

    public Pedido findById(Long id){
        return this.pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido não encontrado"));
    }

    public List<Pedido> findByParam(Pedido pedido){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Pedido> example = Example.of(pedido, matcher);
        return this.pedidoRepository.findAll(example);
    }
}
