package com.lidiagaldino.finances.application.usecases.gainCategory;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.GainCategory;
import com.lidiagaldino.finances.domain.repositories.GainCategoryRepository;
import com.lidiagaldino.finances.domain.usecases.gainCategory.FindGainCategoryByIdUsecase;

@Service
public class FindGainCategoryById implements FindGainCategoryByIdUsecase {
  private final GainCategoryRepository gainCategoryRepository;

  public FindGainCategoryById(GainCategoryRepository gainCategoryRepository) {
    this.gainCategoryRepository = gainCategoryRepository;
  }

  public GainCategory show(Integer id) {
    var category = gainCategoryRepository.showGainCategory(id);
    if(category.isEmpty()) throw new RuntimeException("gain category not found");
    return category.get();
  }
}
