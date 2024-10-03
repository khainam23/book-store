package com.store.book.entity;

import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.BOOK)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(nullable = false)
    @NonNull
    String title;
    @Column(nullable = false)
    @NotNull
    String author;
    @Column(nullable = false)
    @NotNull
    String publisher;
    LocalDate publicationDate;
    @Column(nullable = false)
    @NotNull
    String isbn;
    double price;
    int stockQuantity;
    String description;
    String coverImageUrl;
}
