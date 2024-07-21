package com.lidiagaldino.finances.domain.usecases.expense;

import com.lidiagaldino.finances.domain.entities.Expense;

public interface CreateExpenseUsecase {
  Expense saveExpense(Expense expense);
}
