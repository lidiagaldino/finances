package com.lidiagaldino.finances.domain.repositories;

import java.util.Optional;

import com.lidiagaldino.finances.domain.entities.GainCategory;

public interface GainCategoryRepository {
    Optional<GainCategory> showGainCategory(Integer id);
}
