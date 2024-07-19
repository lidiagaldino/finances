package com.lidiagaldino.finances.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "tbl_gain")
@Getter
public class Gain {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private Float value;
  @Column(nullable = false)
  private Instant date;
  private String description;

  @ManyToOne
  @JoinColumn(name = "gain_category_id")
  private GainCategory gainCategory;

  @ManyToOne
  @JoinColumn(name = "bank_id")
  private Bank bank;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
