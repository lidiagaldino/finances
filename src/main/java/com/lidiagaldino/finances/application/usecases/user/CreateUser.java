package com.lidiagaldino.finances.application.usecases.user;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lidiagaldino.finances.domain.entities.User;
import com.lidiagaldino.finances.domain.interfaces.PasswordCryptography;
import com.lidiagaldino.finances.domain.repositories.UserRepository;
import com.lidiagaldino.finances.domain.usecases.user.CreateUserUsecase;

@Service
public class CreateUser implements CreateUserUsecase{

  final UserRepository userRepository;
  final PasswordCryptography passwordCryptography;

  public CreateUser(UserRepository userRepository, PasswordCryptography passwordCryptography) {
    this.userRepository = userRepository;
    this.passwordCryptography = passwordCryptography;
  }

  public User saveUser(User user) {
    var emailAlreadyExists = userRepository.showByEmail(user.getEmail());
    if(emailAlreadyExists.isPresent()) throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
    user.setPassword(passwordCryptography.encode(user.getPassword()));
    return userRepository.save(user);
  }
}
