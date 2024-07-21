package com.lidiagaldino.finances.domain.repositories;

import java.util.Optional;

import com.lidiagaldino.finances.domain.entities.User;

public interface UserRepository {
  User save(User user);
  void delete(Integer id);
  Optional<User> show(Integer id);
  Optional<User> showByEmail(String email);
}
