package com.lidiagaldino.finances.application.usecases.expenseCategory;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.ExpenseCategory;
import com.lidiagaldino.finances.domain.exceptions.NotFoundException;
import com.lidiagaldino.finances.domain.repositories.ExpenseCategoryRepository;
import com.lidiagaldino.finances.domain.usecases.expenseCategory.FindExpenseCategoryByIdUsecase;

@Service
public class FindExpenseCategoryById implements FindExpenseCategoryByIdUsecase{
  private final ExpenseCategoryRepository expenseCategoryRepository;

  public FindExpenseCategoryById(ExpenseCategoryRepository expenseCategoryRepository) {
    this.expenseCategoryRepository = expenseCategoryRepository;
  }
  @Override
  public ExpenseCategory showExpenseCategory(Integer id) {
    var expenseCategory = expenseCategoryRepository.showExpenseCategory(id);
    if(expenseCategory.isEmpty()) throw new NotFoundException("EXPENSE_CATEGORY");
    return expenseCategory.get();
  }
}
