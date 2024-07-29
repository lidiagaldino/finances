package com.lidiagaldino.finances.domain.usecases.gain;

import com.lidiagaldino.finances.domain.entities.Gain;

public interface FindGainByIdUsecase {
  Gain show(Integer id);
}
