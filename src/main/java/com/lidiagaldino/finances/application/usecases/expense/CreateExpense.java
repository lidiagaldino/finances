package com.lidiagaldino.finances.application.usecases.expense;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Expense;
import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.domain.usecases.expense.CreateExpenseUsecase;

@Service
public class CreateExpense implements CreateExpenseUsecase{
  private final ExpenseRepository expenseRepository;

  public CreateExpense(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public Expense saveExpense(Expense expense) {
    return expenseRepository.save(expense);
  }
}
