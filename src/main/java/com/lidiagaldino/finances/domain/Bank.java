package com.lidiagaldino.finances.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_bank")
public class Bank {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(unique = true, nullable = false)
  private String name;
}
