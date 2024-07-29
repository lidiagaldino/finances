package com.lidiagaldino.finances.domain.usecases.gain;

import com.lidiagaldino.finances.domain.entities.Gain;

public interface CreateGainUsecase {
  Gain saveGain(Gain gain);
}
