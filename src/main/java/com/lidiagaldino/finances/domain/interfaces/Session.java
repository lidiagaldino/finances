package com.lidiagaldino.finances.domain.interfaces;

import com.lidiagaldino.finances.domain.entities.User;

public interface Session {
  String generateToken(User User);
}
