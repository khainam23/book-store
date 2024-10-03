package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.STATUS_TOKEN)
public class TokenStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String description;
}
