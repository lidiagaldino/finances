package com.lidiagaldino.finances.application.usecases.gain;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Gain;
import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.domain.usecases.gain.UpdateGainUsecase;

@Service
public class UpdateGain implements UpdateGainUsecase {
  private final GainRepository gainRepository;

  public UpdateGain(GainRepository gainRepository) {
    this.gainRepository = gainRepository;
  }

  public Gain updateGain(Gain gain) {
    return gainRepository.update(gain);
  }
}
