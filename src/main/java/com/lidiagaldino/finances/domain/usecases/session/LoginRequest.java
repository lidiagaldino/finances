package com.lidiagaldino.finances.domain.usecases.session;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
  String email;
  String password;
}
