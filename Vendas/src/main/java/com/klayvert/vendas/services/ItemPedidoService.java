package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.ItemPedido;
import com.klayvert.vendas.domain.repository.ItemPedidoRepository;
import com.klayvert.vendas.rest.dtos.ItemPedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public ItemPedidoService(ItemPedidoRepository itemPedidoRepository){
        this.itemPedidoRepository = itemPedidoRepository;
    }

    public List<ItemPedidoDTO> findAll(){
        return this.itemPedidoRepository.findAll()
                .stream()
                .map(ItemPedidoDTO::toDto)
                .collect(Collectors.toList());
    }

    public ItemPedidoDTO save(ItemPedidoDTO dto){
        ItemPedido itemPedido = ItemPedidoDTO.toObj(dto);

        return ItemPedidoDTO.toDto(itemPedidoRepository.save(itemPedido));
    }

    public void delete(Long id){
        this.itemPedidoRepository.delete(this.findById(id));
    }

    public ItemPedidoDTO update(ItemPedidoDTO dto){
        ItemPedido itemPedido = ItemPedidoDTO.toObj(dto);
        return ItemPedidoDTO.toDto(itemPedidoRepository.save(itemPedido));
    }

    public ItemPedido findById(Long id){
        return this.itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public List<ItemPedido> findByParam(ItemPedido itemPedido){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<ItemPedido> example = Example.of(itemPedido, matcher);
        return this.itemPedidoRepository.findAll(example);
    }
}
