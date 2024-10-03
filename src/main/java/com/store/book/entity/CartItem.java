package com.store.book.entity;

import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.CART_ITEM)
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    ShoppingCart idCart;
    @ManyToOne
    Book idBook;
    @Column(nullable = false)
    @NotNull
    int quantity;
}
