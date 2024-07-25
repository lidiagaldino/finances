package com.lidiagaldino.finances.domain.repositories;

import java.util.Optional;

import com.lidiagaldino.finances.domain.entities.Bank;

public interface BankRepository {
  Optional<Bank> show(Integer id);
}
