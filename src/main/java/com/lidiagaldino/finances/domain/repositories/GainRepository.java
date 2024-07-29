package com.lidiagaldino.finances.domain.repositories;

import com.lidiagaldino.finances.domain.entities.Gain;

import java.util.Optional;
import java.util.Set;

public interface GainRepository {
  Gain save(Gain gain);
  void delete(Integer id);
  Gain update(Gain gain);
  Optional<Gain> show(Integer id);
  Set<Gain> list(Integer userId);
}
