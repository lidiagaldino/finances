package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.Expense;
import com.lidiagaldino.finances.domain.repositories.ExpenseRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaExpense;

@Repository
public class ExpenseRepositoryImpl implements ExpenseRepository{
  private final JpaExpense jpaExpense;

  public ExpenseRepositoryImpl(JpaExpense jpaExpense) {
    this.jpaExpense = jpaExpense;
  }

  public Expense save(Expense expense) {
    return jpaExpense.save(expense);
  }

  public void delete(Integer id) {
    jpaExpense.deleteById(id);
    return;
  }

  public Expense update(Expense expense) {
    return jpaExpense.save(expense);
  }

  public Optional<Expense> show(Integer id) {
    var expense = jpaExpense.findById(id);
    System.out.println(expense.get().getBank().toString());
    return expense;
  }

  public Set<Expense> list(Integer userId) {
    return jpaExpense.findByUserId(userId);
  }
  
}
