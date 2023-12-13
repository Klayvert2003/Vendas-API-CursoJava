package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.rest.dtos.ClienteDTO;
import com.klayvert.vendas.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/find_all")
    public List<ClienteDTO> findAll(){
        return this.clienteService.findAll();
    }

    @PostMapping("/save")
    public ClienteDTO save(@RequestBody @Valid ClienteDTO clienteDTO){
        return this.clienteService.save(clienteDTO);
    }
}
