package com.lidiagaldino.finances.application.usecases.gain;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.domain.usecases.gain.DeleteGainUsecase;

@Service
public class DeleteGain implements DeleteGainUsecase {
  private final GainRepository gainRepository;

  public DeleteGain(GainRepository gainRepository) {
    this.gainRepository = gainRepository;
  }

  public void deleteGain(Integer id) {
    gainRepository.delete(id);
    return;
  }
}
