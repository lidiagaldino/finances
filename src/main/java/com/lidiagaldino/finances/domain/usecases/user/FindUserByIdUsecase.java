package com.lidiagaldino.finances.domain.usecases.user;

import com.lidiagaldino.finances.domain.entities.User;

public interface FindUserByIdUsecase {
  User showUser(Integer userId);
}
