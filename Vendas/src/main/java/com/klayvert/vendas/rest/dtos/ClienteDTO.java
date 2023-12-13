package com.klayvert.vendas.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.klayvert.vendas.domain.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String nome;

    public static ClienteDTO toDto(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();

        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        return dto;
    }

    public static Cliente toObj(ClienteDTO dto){
        Cliente cliente = new Cliente();

        cliente.setId(dto.getId());
        cliente.setNome(dto.getNome());

        return cliente;
    }
}
