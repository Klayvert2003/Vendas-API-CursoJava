package com.klayvert.vendas.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.klayvert.vendas.domain.entities.Cliente;
import com.klayvert.vendas.domain.entities.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private LocalDateTime dataPedido;

    private float total;

    private List<Cliente> cliente = new ArrayList<>();

    public static PedidoDTO toDto(Pedido pedido){
        PedidoDTO dto = new PedidoDTO();

        dto.setId(pedido.getId());
        dto.setDataPedido(pedido.getDataPedido());
        dto.setTotal(pedido.getTotal());
        dto.setCliente(pedido.getClientes());

        return dto;
    }

    public static Pedido toObj(PedidoDTO dto){
        Pedido pedido = new Pedido();

        pedido.setId(dto.getId());
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setTotal(dto.getTotal());
        pedido.setClientes(dto.getCliente());

        return pedido;
    }
}
