package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.domain.entities.ItemPedido;
import com.klayvert.vendas.rest.dtos.ItemPedidoDTO;
import com.klayvert.vendas.services.ItemPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/item_pedido")
public class ItemPedidoController {
    ItemPedidoService itemPedidoService;

    @Autowired
    public ItemPedidoController(ItemPedidoService itemPedidoService){
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping("/find_all")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemPedidoDTO> findAll(){
        return this.itemPedidoService.findAll();
    }

    @GetMapping("/find_by")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemPedido> findByParam(ItemPedido param){
        return this.itemPedidoService.findByParam(param);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemPedidoDTO save(@RequestBody @Valid ItemPedidoDTO itemPedidoDTO){
        return this.itemPedidoService.save(itemPedidoDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.itemPedidoService.delete(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public ItemPedidoDTO update(@RequestBody @Valid ItemPedidoDTO itemPedidoDTO){
        return this.itemPedidoService.update(itemPedidoDTO);
    }
}
