package com.lidiagaldino.finances.infra.persistence.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.User;

public interface JpaUser extends JpaRepository<User, Integer> {
  Optional<User> findByEmail(String email);
}
