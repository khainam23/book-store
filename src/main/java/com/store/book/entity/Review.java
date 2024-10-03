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
@Table(name = ICNameEntity.REVIEW)
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    Book idBook;
    @ManyToOne
    User idUser;
    @Column(nullable = false)
    int rating;
    String comment;
    @Column(nullable = false)
    LocalDate createdDate;
}
