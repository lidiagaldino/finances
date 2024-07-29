package com.lidiagaldino.finances.domain.usecases.gain;

import java.util.Set;

import com.lidiagaldino.finances.domain.entities.Gain;

public interface FindAllGainsByUserUsecase {
  Set<Gain> findAllGains(Integer userId);
}
