package com.lidiagaldino.finances.application.usecases.gain;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Gain;
import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.domain.usecases.gain.CreateGainUsecase;

@Service
public class CreateGain implements CreateGainUsecase {
  private final GainRepository gainRepository;

  public CreateGain(GainRepository gainRepository) {
    this.gainRepository = gainRepository;
  }

  public Gain saveGain(Gain gain) {
    return gainRepository.save(gain);
  }
}
