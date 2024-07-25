package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.Bank;
import com.lidiagaldino.finances.domain.repositories.BankRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaBank;

@Repository
public class BankRepositoryImpl implements BankRepository{
  private JpaBank jpaBank;

  public BankRepositoryImpl(JpaBank jpaBank) {
    this.jpaBank = jpaBank;
  }
  public Optional<Bank> show(Integer id) {
    return jpaBank.findById(id);
  }
}
