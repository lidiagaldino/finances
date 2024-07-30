package com.lidiagaldino.finances.application.usecases.expense;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Expense;
import com.lidiagaldino.finances.domain.exceptions.NotFoundException;
import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.domain.usecases.expense.FindExpenseByIdUsecase;

@Service
public class FindExpenseById implements FindExpenseByIdUsecase {

  private final ExpenseRepository expenseRepository;

  public FindExpenseById(ExpenseRepository expenseRepository) {
    this.expenseRepository = expenseRepository;
  }

  public Expense showExpense(Integer id) {
    var expense = expenseRepository.show(id);
    if(expense.isEmpty()) throw new NotFoundException("EXPENSE");
    return expense.get();
  }
  
}
