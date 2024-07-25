package com.lidiagaldino.finances.application.usecases.expense;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Expense;
import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.domain.usecases.expense.FindAllExpensesByUserUsecase;

@Service
public class FindAllExpensesByUser implements FindAllExpensesByUserUsecase{
  private final ExpenseRepository expenseRepository;

  public FindAllExpensesByUser(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public Set<Expense> findAllExpenses(Integer userId) {
    return expenseRepository.list(userId);
  }
}
