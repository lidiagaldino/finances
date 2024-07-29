package com.lidiagaldino.finances.infra.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lidiagaldino.finances.domain.entities.GainCategory;

public interface JpaGainCategory  extends JpaRepository<GainCategory, Integer>{
  
}
