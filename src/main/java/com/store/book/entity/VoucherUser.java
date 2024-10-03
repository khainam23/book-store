package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.VOUCHER_USER)
public class VoucherUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    Voucher idVoucher;
    @ManyToOne
    User idUser;
    @Column(nullable = false)
    int usageCount;
}
