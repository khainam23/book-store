package com.store.book.service;

import com.store.book.dto.request.LoginRequestDTO;
import com.store.book.dto.response.LoginResponseDTO;
import com.store.book.dto.response.TokenResponseDTO;
import com.store.book.entity.User;
import com.store.book.pojo.UserDetailToken;
import com.store.book.repository.IAuthRepository;
import com.store.book.util.JwtUtil;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthService {
    @Autowired
    IAuthRepository authRepository;
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    PasswordEncoder encoder;

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        String email = loginRequestDTO.getEmail();
        List<User> users = authRepository.findByEmail(email).orElse(new ArrayList<>());
        if (users.size() != 1) return null;
        User user = users.get(0);
        if (encoder.matches(loginRequestDTO.getPassword(), user.getHashPass())) {
            UserDetailToken userDetailToken = new UserDetailToken(
                    user.getId(),
                    user.getUsername(),
                    getNameRoleById(user.getIdRole().getId())
            );
            TokenResponseDTO tokenResponseDTO = new TokenResponseDTO(
                    jwtUtil.generateJwtToken(userDetailToken),
                    null
            );
            return new LoginResponseDTO(
                    tokenResponseDTO,
                    userDetailToken
            );
        }
        return null;
    }

    public String getNameRoleById(UUID idRole) {
        String nameRole = authRepository.findNameRoleById(idRole).orElse("");
        if (nameRole.isBlank()) return null;
        return nameRole;
    }
}
