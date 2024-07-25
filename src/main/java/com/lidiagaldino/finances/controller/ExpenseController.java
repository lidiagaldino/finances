package com.lidiagaldino.finances.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lidiagaldino.finances.application.usecases.bank.FindBankById;
import com.lidiagaldino.finances.application.usecases.expense.CreateExpense;
import com.lidiagaldino.finances.application.usecases.expense.DeleteExpense;
import com.lidiagaldino.finances.application.usecases.expense.FindAllExpensesByUser;
import com.lidiagaldino.finances.application.usecases.expense.FindExpenseById;
import com.lidiagaldino.finances.application.usecases.expense.UpdateExpense;
import com.lidiagaldino.finances.application.usecases.expenseCategory.FindExpenseCategoryById;
import com.lidiagaldino.finances.application.usecases.user.FindUserById;
import com.lidiagaldino.finances.controller.dto.ExpenseRequestDto;
import com.lidiagaldino.finances.domain.entities.Expense;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/expenses")
public class ExpenseController {
  private final CreateExpense createExpense;
  private final DeleteExpense deleteExpense;
  private final FindAllExpensesByUser findAllExpensesByUser;
  private final FindExpenseById findExpenseById;
  private final UpdateExpense updateExpense;
  private final FindUserById findUserById;
  private final FindBankById findBankById;
  private final FindExpenseCategoryById findExpenseCategoryById;

  public ExpenseController(
    CreateExpense createExpense, 
    DeleteExpense deleteExpense, 
    FindAllExpensesByUser findAllExpensesByUser, 
    FindExpenseById findExpenseById,
    UpdateExpense updateExpense,
    FindUserById findUserById,
    FindBankById findBankById,
    FindExpenseCategoryById findExpenseCategoryById
  ) {
    this.createExpense = createExpense;
    this.deleteExpense = deleteExpense;
    this.findAllExpensesByUser = findAllExpensesByUser;
    this.findExpenseById = findExpenseById;
    this.updateExpense = updateExpense;
    this.findUserById = findUserById;
    this.findBankById = findBankById;
    this.findExpenseCategoryById = findExpenseCategoryById;
  }

  @PostMapping
  public ResponseEntity<Object> postMethodName(@RequestBody ExpenseRequestDto body) {
    var user = findUserById.showUser(body.userId());
      var bank = findBankById.showBank(body.bankId());
      var category = findExpenseCategoryById.showExpenseCategory(body.expenseCategoryId());
      var expense = new Expense();
      expense.setUser(user);
      expense.setBank(bank);
      expense.setExpenseCategory(category);
      expense.setDate(Instant.parse(body.date()));
      expense.setDescription(body.description());
      expense.setValue(body.value());
      return ResponseEntity.status(201).body(createExpense.saveExpense(expense));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteExpense(@PathVariable("id") Integer id) {
    deleteExpense.deleteExpense(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/list/{userId}")
  public ResponseEntity<Object> showByUser(@PathVariable("userId") Integer userId) {
      return ResponseEntity.ok(findAllExpensesByUser.findAllExpenses(userId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> show(@PathVariable("id") Integer id) {
      var expense = findExpenseById.showExpense(id);
      return ResponseEntity.status(200).body(expense);
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody ExpenseRequestDto body) {
      var user = findUserById.showUser(body.userId());
      var bank = findBankById.showBank(body.bankId());
      var category = findExpenseCategoryById.showExpenseCategory(body.expenseCategoryId());
      var expense = new Expense();
      expense.setId(id);
      expense.setUser(user);
      expense.setBank(bank);
      expense.setExpenseCategory(category);
      expense.setDate(Instant.parse(body.date()));
      expense.setDescription(body.description());
      expense.setValue(body.value());
      return ResponseEntity.ok(updateExpense.updateExpense(expense));
  }
  
}
