package com.lidiagaldino.finances.domain.usecases.expense;

import com.lidiagaldino.finances.domain.entities.Expense;

public interface UpdateExpenseUsecase {
  Expense updateExpense(Expense expense);
}
