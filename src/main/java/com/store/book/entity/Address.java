package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.ADDRESS)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    @NonNull
    User idUser;
    String addressLine;
    @Column(nullable = false)
    @NonNull
    String city;
    @Column(nullable = false)
    @NonNull
    LocalDate updateDate;
}
