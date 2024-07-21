package com.lidiagaldino.finances.domain.interfaces;

public interface PasswordCryptography {
  String encode(String password);
  Boolean matches(String hashedPassword, String password);
}
