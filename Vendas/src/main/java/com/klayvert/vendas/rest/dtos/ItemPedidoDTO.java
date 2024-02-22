package com.klayvert.vendas.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.klayvert.vendas.domain.entities.ItemPedido;
import com.klayvert.vendas.domain.entities.Pedido;
import com.klayvert.vendas.domain.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private Pedido pedido;

    private Produto produto;

    private Integer quantidade;

    public static ItemPedidoDTO toDto(ItemPedido itemPedido){
        ItemPedidoDTO dto = new ItemPedidoDTO();

        dto.setId(itemPedido.getId());
        dto.setPedido(itemPedido.getPedido());
        dto.setProduto(itemPedido.getProduto());
        dto.setQuantidade(itemPedido.getQuantidade());

        return dto;
    }

    public static ItemPedido toObj(ItemPedidoDTO dto){
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setId(dto.getId());
        itemPedido.setPedido(dto.getPedido());
        itemPedido.setProduto(dto.getProduto());
        itemPedido.setQuantidade(dto.getQuantidade());

        return itemPedido;
    }
}
