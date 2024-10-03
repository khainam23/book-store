package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.BOOK_GENRE)
public class BookGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToMany
    List<Book> idBook;
    @ManyToMany
    List<Category> idCategory;
}
