package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.ExpenseCategory;
import com.lidiagaldino.finances.domain.repositories.ExpenseCategoryRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaExpenseCategory;

@Repository
public class ExpenseCategoryRepositoryImpl implements ExpenseCategoryRepository{
  private final JpaExpenseCategory jpaExpenseCategory;

  public ExpenseCategoryRepositoryImpl(JpaExpenseCategory jpaExpenseCategory) {
    this.jpaExpenseCategory = jpaExpenseCategory;
  }

  public Optional<ExpenseCategory> showExpenseCategory(Integer id) {
    return jpaExpenseCategory.findById(id);
  }
}
