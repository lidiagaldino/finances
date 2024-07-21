package com.lidiagaldino.finances.domain.repositories;

import java.util.Set;

import com.lidiagaldino.finances.domain.entities.Expense;

public interface ExpenseRepository {
  Expense save(Expense expense);
  void delete(Integer id);
  Expense update(Expense expense);
  Expense show(Integer id);
  Set<Expense> list(Integer userId);
}
