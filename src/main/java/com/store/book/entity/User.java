package com.store.book.entity;


import com.store.book.config.ICNameEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = ICNameEntity.USER)
@Data
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    UUID id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String hashPass;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    String firstName;
    @Column(nullable = false)
    String lastName;
    @Column(nullable = false)
    String phone;
    @Column(nullable = false)
    LocalDate dob;
    @ManyToOne
    Role idRole;
    @ManyToOne
    PriorityUser idPriority;
}
