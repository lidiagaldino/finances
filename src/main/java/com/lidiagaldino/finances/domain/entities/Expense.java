package com.lidiagaldino.finances.domain.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_expense")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Float value;
  @Column(nullable = false)
  private Instant date;
  private String description;

  @ManyToOne
  @JoinColumn(name = "expense_category_id")
  private ExpenseCategory expenseCategory;

  @ManyToOne
  @JoinColumn(name = "bank_id")
  private Bank bank;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
