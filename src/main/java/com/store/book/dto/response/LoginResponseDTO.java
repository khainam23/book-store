package com.store.book.dto.response;

import com.store.book.pojo.UserDetailToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class LoginResponseDTO {
    TokenResponseDTO token;
    UserDetailToken user;
}
