package com.klayvert.vendas.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataPedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "total", nullable = false)
    private float total;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "pedidoCliente",
    joinColumns = @JoinColumn(name = "pedidoId"),
    inverseJoinColumns = @JoinColumn(name = "clienteId"))
    private List<Cliente> clientes = new ArrayList<>();
}
