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
@Table(name = ICNameEntity.ORDER)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    @NotNull
    User idUser;
    @Column(nullable = false)
    @NotNull
    LocalDate orderDate;
    @Column(nullable = false)
    @NotNull
    double totalAmount;
    @ManyToOne
    @NotNull
    OrderStatus idStatus;
    @ManyToOne
    @NotNull
    Address idAddress;
    @ManyToOne
    Voucher idVoucher;
}
