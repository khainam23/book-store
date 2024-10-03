package com.store.book.entity;

import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.CATEGORY)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    @NotNull
    String name;
    String description;
    String coverImageUrl;
}
