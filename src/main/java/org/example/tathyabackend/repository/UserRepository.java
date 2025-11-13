package org.example.tathyabackend.repository;

import org.example.tathyabackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);

    boolean existsByEmail(String attr0);
}