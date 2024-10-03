package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.VOUCHER)
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false, unique = true)
    @NotNull
    String code;
    String description;
    @Column(nullable = false)
    double discountValue;
    @Column(nullable = false)
    @NotNull
    LocalDate startDate;
    @Column(nullable = false)
    @NotNull
    LocalDate endDate;
    @Column(nullable = false, columnDefinition = "boolean default false")
    boolean isActive;
    @Column(nullable = false)
    @NotNull
    LocalDate updateDate;
}
