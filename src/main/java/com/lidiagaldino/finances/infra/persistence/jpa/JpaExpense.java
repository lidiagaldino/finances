package com.lidiagaldino.finances.infra.persistence.jpa;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.Expense;

public interface JpaExpense extends JpaRepository<Expense, Integer> {
  Set<Expense> findByUserId(Integer userId);
}
