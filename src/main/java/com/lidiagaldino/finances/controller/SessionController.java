package com.lidiagaldino.finances.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lidiagaldino.finances.application.usecases.session.LoginUser;
import com.lidiagaldino.finances.domain.usecases.session.LoginRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class SessionController {
  final LoginUser loginUser;

  public SessionController(LoginUser loginUser) {
    this.loginUser = loginUser;
  }

  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody LoginRequest body) {
      var token = loginUser.login(body);
      return ResponseEntity.ok(token);
  }
  
}
