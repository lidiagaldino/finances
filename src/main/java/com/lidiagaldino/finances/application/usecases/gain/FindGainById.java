package com.lidiagaldino.finances.application.usecases.gain;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Gain;
import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.domain.usecases.gain.FindGainByIdUsecase;

@Service
public class FindGainById implements FindGainByIdUsecase {
  private final GainRepository gainRepository;

  public FindGainById(GainRepository gainRepository) {
    this.gainRepository = gainRepository;
  }

  public Gain show(Integer id) {
    var gain = this.gainRepository.show(id) ;
    if(gain.isEmpty()) throw new RuntimeException("gain not found");
    return gain.get();
  }
}
