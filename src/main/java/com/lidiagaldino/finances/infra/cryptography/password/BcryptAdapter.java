package com.lidiagaldino.finances.infra.cryptography.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.lidiagaldino.finances.domain.interfaces.PasswordCryptography;

@Component
public class BcryptAdapter implements PasswordCryptography {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public BcryptAdapter() {
    this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
  }
  @Override
  public String encode(String password) {
    return bCryptPasswordEncoder.encode(password);
  }

  @Override
  public Boolean matches(String hashedPassword, String password) {
    return bCryptPasswordEncoder.matches(password, hashedPassword);
  }
}
