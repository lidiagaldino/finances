package com.lidiagaldino.finances.infra.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.ExpenseCategory;

public interface JpaExpenseCategory extends JpaRepository<ExpenseCategory, Integer>{
  
}
