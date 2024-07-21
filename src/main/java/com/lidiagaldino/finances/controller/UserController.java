package com.lidiagaldino.finances.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lidiagaldino.finances.application.usecases.user.CreateUser;
import com.lidiagaldino.finances.application.usecases.user.FindUserById;
import com.lidiagaldino.finances.domain.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {
  final CreateUser createUser;
  final FindUserById findUserById;

  public UserController(CreateUser createUser, FindUserById findUserById) {
    this.createUser = createUser;
    this.findUserById = findUserById;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> save(@RequestBody User user) {
    return ResponseEntity.status(201).body(createUser.saveUser(user));
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Object> show(@PathVariable("id") Integer id) {
      return ResponseEntity.ok(findUserById.showUser(id)); 
  }
  
}
