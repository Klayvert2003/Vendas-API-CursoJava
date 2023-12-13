package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.Pedido;
import com.klayvert.vendas.domain.repository.PedidoRepository;
import com.klayvert.vendas.rest.dtos.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    PedidoRepository pedidoRepository;

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
}
