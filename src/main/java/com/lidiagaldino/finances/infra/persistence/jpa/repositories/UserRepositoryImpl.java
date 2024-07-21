package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.User;
import com.lidiagaldino.finances.domain.repositories.UserRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaUser;

@Repository
public class UserRepositoryImpl implements UserRepository{
  private final JpaUser jpaUser;

  public UserRepositoryImpl(JpaUser jpaUser) {
    this.jpaUser = jpaUser;
  }

  public User save(User user) {
    return jpaUser.save(user);
  }

  public void delete(Integer id) {
    jpaUser.deleteById(id);
    return;
  }

  public Optional<User> show(Integer id) {
    return jpaUser.findById(id);
  }

  public Optional<User> showByEmail(String email) {
    return jpaUser.findByEmail(email);
  }
}
