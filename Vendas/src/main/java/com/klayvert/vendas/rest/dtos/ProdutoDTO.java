package com.klayvert.vendas.rest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.klayvert.vendas.domain.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    private String descricao;

    private float precoUnitario;

    public static ProdutoDTO toDto(Produto produto){
        ProdutoDTO dto = new ProdutoDTO();

        dto.setId(produto.getId());
        dto.setDescricao(produto.getDescricao());
        dto.setPrecoUnitario(produto.getPrecoUnitario());

        return dto;
    }

    public static Produto toObj(ProdutoDTO dto){
        Produto produto = new Produto();

        produto.setId(dto.getId());
        produto.setDescricao(dto.getDescricao());
        produto.setPrecoUnitario(dto.getPrecoUnitario());

        return produto;
    }

}
