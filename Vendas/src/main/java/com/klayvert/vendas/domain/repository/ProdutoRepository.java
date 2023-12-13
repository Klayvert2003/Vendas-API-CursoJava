package com.klayvert.vendas.domain.repository;

import com.klayvert.vendas.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
}
