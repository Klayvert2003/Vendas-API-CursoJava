package com.klayvert.vendas.services;

import com.klayvert.vendas.domain.entities.UserAuthenticated;
import com.klayvert.vendas.domain.repository.UserRepository;
import com.klayvert.vendas.rest.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return this.repository
                .findUserByUsername(username)
                .map(UserAuthenticated::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }

    public UserDTO save(UserDTO dto) {
        dto.setPassword(this.passwordEncoder.encode(dto.getPassword()));
        return UserDTO.toDTO(this.repository.save(UserDTO.toOBJ(dto)));
    }
}
