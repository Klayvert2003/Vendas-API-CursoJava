package com.klayvert.vendas.rest.controllers;

import com.klayvert.vendas.rest.dtos.LoginResponseDTO;
import com.klayvert.vendas.rest.dtos.UserDTO;
import com.klayvert.vendas.services.AuthenticationService;
import com.klayvert.vendas.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserDetailsServiceImpl userService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserDetailsServiceImpl userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponseDTO authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }

    @PostMapping("/register")
    public UserDTO save(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }
}
