package com.lidiagaldino.finances.application.usecases.expense;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Expense;
import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.domain.usecases.expense.UpdateExpenseUsecase;

@Service
public class UpdateExpense implements UpdateExpenseUsecase{
  private final ExpenseRepository expenseRepository;

  public UpdateExpense(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public Expense updateExpense(Expense expense) {
    return expenseRepository.update(expense);
  }
}
