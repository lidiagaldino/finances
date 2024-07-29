package com.lidiagaldino.finances.domain.entities;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  @JsonIgnore
  private String password;
  @Column(unique = true, nullable = false)
  private String email;

  @Formula("(select sum(value) from tbl_gain where tbl_gain.user_id = id)")
  private Float gains;
  
  @Formula("(select sum(value) from tbl_expense where tbl_expense.user_id = id)")
  private Float expenses;

  @Formula("(select sum(value) from tbl_gain where tbl_gain.user_id = id) - (select sum(value) from tbl_expense where tbl_expense.user_id = id)")
  private Float balance;
}
