package com.lidiagaldino.finances.domain;

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
  
  @Column(unique = true, nullable = false)
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(unique = true, nullable = false)
  private String email;
}
