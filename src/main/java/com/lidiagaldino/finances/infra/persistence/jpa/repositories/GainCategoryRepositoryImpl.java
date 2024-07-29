package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.GainCategory;
import com.lidiagaldino.finances.domain.repositories.GainCategoryRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaGainCategory;

@Repository
public class GainCategoryRepositoryImpl implements GainCategoryRepository{
  private final JpaGainCategory jpaGainCategory;

  public GainCategoryRepositoryImpl(JpaGainCategory jpaGainCategory) {
    this.jpaGainCategory = jpaGainCategory;
  }

  public Optional<GainCategory> showGainCategory(Integer id) {
    return jpaGainCategory.findById(id);
  }
  
}
