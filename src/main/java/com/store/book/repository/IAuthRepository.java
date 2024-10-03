package com.store.book.repository;

import com.store.book.entity.Role;
import com.store.book.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IAuthRepository extends JpaRepository<User, UUID> {
    Optional<List<User>> findByEmail(String email);

    @Query("select r.description from Role r where r.id=:idRole")
    Optional<String> findNameRoleById(@Param("idRole") UUID idRole);
}
