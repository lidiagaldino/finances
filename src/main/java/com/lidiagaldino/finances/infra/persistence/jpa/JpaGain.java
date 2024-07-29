package com.lidiagaldino.finances.infra.persistence.jpa;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.Gain;

public interface JpaGain extends JpaRepository<Gain, Integer>{
  Set<Gain> findByUserId(Integer userId);
}
