package com.store.book.entity;

import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.ROLE)
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String description;
}
