package com.lidiagaldino.finances.controller.dto;

public record GainRequestDto(
  Float value,
  String date,
  String description,
  Integer gainCategoryId,
  Integer bankId,
  Integer userId 
) {
  
}
