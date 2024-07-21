package com.lidiagaldino.finances.domain.usecases.expense;

import java.util.Set;

import com.lidiagaldino.finances.domain.entities.Expense;

public interface FindAllExpensesByUser {
  Set<Expense> findAllExpenses(Integer userId);
}
