package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.rest.dtos.PedidoDTO;
import com.klayvert.vendas.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @GetMapping("/find_all")
    public List<PedidoDTO> findAll(){
        return this.pedidoService.findAll();
    }

    @PostMapping("/save")
    public PedidoDTO save(@RequestBody @Valid PedidoDTO pedidoDTO){
        return this.pedidoService.save(pedidoDTO);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        this.pedidoService.delete(id);
    }

    @PutMapping("/update")
    @ResponseBody
    public PedidoDTO update(@RequestBody @Valid PedidoDTO pedidoDTO){
        return this.pedidoService.update(pedidoDTO);
    }
}
