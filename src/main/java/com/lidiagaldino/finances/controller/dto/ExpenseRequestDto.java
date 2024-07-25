package com.lidiagaldino.finances.controller.dto;

public record ExpenseRequestDto(
  Float value,
  String date,
  String description,
  Integer expenseCategoryId,
  Integer bankId,
  Integer userId 
) {
  
}
