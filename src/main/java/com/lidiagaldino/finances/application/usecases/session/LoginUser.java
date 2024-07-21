package com.lidiagaldino.finances.application.usecases.session;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.interfaces.Session;
import com.lidiagaldino.finances.domain.repositories.UserRepository;
import com.lidiagaldino.finances.domain.usecases.session.LoginRequest;
import com.lidiagaldino.finances.domain.usecases.session.LoginResponse;
import com.lidiagaldino.finances.domain.interfaces.PasswordCryptography;

@Service
public class LoginUser {
  private final UserRepository userRepository;
  private final Session session;
  private final PasswordCryptography passwordCryptography;

  public LoginUser(UserRepository userRepository, Session session, PasswordCryptography passwordCryptography) {
    this.userRepository = userRepository;
    this.session = session;
    this.passwordCryptography = passwordCryptography;
  }
  public LoginResponse login(LoginRequest user) {
    var userResponse = userRepository.showByEmail(user.getEmail());
    if(
      userResponse.isEmpty() || 
      !passwordCryptography.matches(userResponse.get().getPassword(), user.getPassword())
    ) throw new RuntimeException("email or password incorrect");
    var token = session.generateToken(userResponse.get());
    LoginResponse response = new LoginResponse();
    response.setToken(token);
    response.setExpiresIn(1800L);
    return response;
  }
}
