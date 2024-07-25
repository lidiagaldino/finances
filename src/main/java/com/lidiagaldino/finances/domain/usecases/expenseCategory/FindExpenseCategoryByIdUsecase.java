package com.lidiagaldino.finances.domain.usecases.expenseCategory;

import com.lidiagaldino.finances.domain.entities.ExpenseCategory;

public interface FindExpenseCategoryByIdUsecase {
  ExpenseCategory showExpenseCategory(Integer id);
}
