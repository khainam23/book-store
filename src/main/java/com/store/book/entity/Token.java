package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.TOKEN)
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String token;
    @OneToOne
    User idUser;
    @Column(nullable = false)
    LocalDate createdDate;
    @Column(nullable = false)
    LocalDate expiredDate;
    @ManyToOne
    TokenStatus idStatus;
}
