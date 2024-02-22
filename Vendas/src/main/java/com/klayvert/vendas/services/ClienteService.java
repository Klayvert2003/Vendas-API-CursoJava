package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.Cliente;
import com.klayvert.vendas.domain.repository.ClienteRepository;
import com.klayvert.vendas.rest.dtos.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> findAll(){
        return this.clienteRepository.findAll()
                .stream()
                .map(ClienteDTO::toDto)
                .collect(Collectors.toList());
    }

    public ClienteDTO save(ClienteDTO dto){
        Cliente cliente = ClienteDTO.toObj(dto);

        return ClienteDTO.toDto(this.clienteRepository.save(cliente));
    }

    public void delete(Long id){
        this.clienteRepository.delete(this.findById(id));
    }


    public Cliente findById(Long id){
        return this.clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }
}
