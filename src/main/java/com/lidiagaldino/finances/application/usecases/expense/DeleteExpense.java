package com.lidiagaldino.finances.application.usecases.expense;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.domain.usecases.expense.DeleteExpenseUsecase;

@Service
public class DeleteExpense implements DeleteExpenseUsecase{
  private final ExpenseRepository expenseRepository;

  public DeleteExpense(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public void deleteExpense(Integer id) {
    expenseRepository.delete(id);
    return;
  }
}
