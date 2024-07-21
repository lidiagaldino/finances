package com.lidiagaldino.finances.application.usecases.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.lidiagaldino.finances.domain.entities.User;
import com.lidiagaldino.finances.domain.repositories.UserRepository;
import com.lidiagaldino.finances.domain.usecases.user.FindUserByIdUsecase;

@Component
public class FindUserById implements FindUserByIdUsecase{
  private final UserRepository userRepository;

  public FindUserById(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User showUser(Integer userId) {
    var user = userRepository.show(userId);
    if(user.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    return user.get();
  }
}
