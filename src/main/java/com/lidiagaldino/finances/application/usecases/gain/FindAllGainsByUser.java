package com.lidiagaldino.finances.application.usecases.gain;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Gain;
import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.domain.usecases.gain.FindAllGainsByUserUsecase;

@Service
public class FindAllGainsByUser implements FindAllGainsByUserUsecase {
  private final GainRepository gainRepository;

  public FindAllGainsByUser(GainRepository gainRepository) {
    this.gainRepository = gainRepository;
  }

  public Set<Gain> findAllGains(Integer userId) {
   return this.gainRepository.list(userId);
  }
}
