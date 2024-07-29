package com.lidiagaldino.finances.domain.usecases.gainCategory;

import com.lidiagaldino.finances.domain.entities.GainCategory;

public interface FindGainCategoryByIdUsecase {
  GainCategory show(Integer id);
}
