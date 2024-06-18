package com.klayvert.vendas.services;

import com.klayvert.vendas.rest.dtos.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final JwtService jwtService;

    @Autowired
    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public LoginResponseDTO authenticate(Authentication authentication) {
        return new LoginResponseDTO(jwtService.generateToken(authentication));
    }
}
