package com.lidiagaldino.finances.infra.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.Bank;

public interface JpaBank extends JpaRepository<Bank, Integer>{
  
}
