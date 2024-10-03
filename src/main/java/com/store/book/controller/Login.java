package com.store.book.controller;

import com.store.book.config.ICEndpoint;
import com.store.book.dto.request.LoginRequestDTO;
import com.store.book.dto.response.LoginResponseDTO;
import com.store.book.service.AuthService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Login {
    @Autowired
    AuthService authService;

    @PostMapping(ICEndpoint.AUTH_LOGIN)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO infoLogin) {
        return ResponseEntity.of(Optional.of(
                authService.login(infoLogin)
        ));
    }
}
