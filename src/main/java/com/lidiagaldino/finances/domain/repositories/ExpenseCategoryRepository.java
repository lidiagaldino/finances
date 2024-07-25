package com.lidiagaldino.finances.domain.repositories;

import java.util.Optional;

import com.lidiagaldino.finances.domain.entities.ExpenseCategory;

public interface ExpenseCategoryRepository {
  Optional<ExpenseCategory> showExpenseCategory(Integer id);
}
