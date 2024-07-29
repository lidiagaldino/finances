package com.lidiagaldino.finances.infra.persistence.jpa.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.lidiagaldino.finances.domain.entities.Gain;
import com.lidiagaldino.finances.domain.repositories.GainRepository;
import com.lidiagaldino.finances.infra.persistence.jpa.JpaGain;

@Repository
public class GainRepositoryImpl implements GainRepository {
  private final JpaGain jpaGain;

  public GainRepositoryImpl(JpaGain jpaGain) {
    this.jpaGain = jpaGain;
  }

  public Gain save(Gain gain) {
    return jpaGain.save(gain);
  }

  public void delete(Integer id) {
    jpaGain.deleteById(id);
    return;
  }

  public Gain update(Gain gain) {
    return jpaGain.save(gain);
  }

  public Optional<Gain> show(Integer id) {
    return jpaGain.findById(id);
  }

  public Set<Gain> list(Integer userId) {
    return jpaGain.findByUserId(userId);
  }
}
