package com.lidiagaldino.finances.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lidiagaldino.finances.application.usecases.bank.FindBankById;
import com.lidiagaldino.finances.application.usecases.gain.CreateGain;
import com.lidiagaldino.finances.application.usecases.gain.DeleteGain;
import com.lidiagaldino.finances.application.usecases.gain.FindAllGainsByUser;
import com.lidiagaldino.finances.application.usecases.gain.FindGainById;
import com.lidiagaldino.finances.application.usecases.gain.UpdateGain;
import com.lidiagaldino.finances.application.usecases.gainCategory.FindGainCategoryById;
import com.lidiagaldino.finances.application.usecases.user.FindUserById;
import com.lidiagaldino.finances.controller.dto.GainRequestDto;
import com.lidiagaldino.finances.domain.entities.Gain;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/gains")
public class GainController {
  private final CreateGain createGain;
  private final DeleteGain deleteGain;
  private final FindAllGainsByUser findAllGainsByUser;
  private final FindGainById findGainById;
  private final UpdateGain updateGain;
  private final FindUserById findUserById;
  private final FindBankById findBankById;
  private final FindGainCategoryById findGainCategoryById;

  public GainController(
    CreateGain createGain, 
    DeleteGain deleteGain, 
    FindAllGainsByUser findAllGainsByUser, 
    FindGainById findGainById,
    UpdateGain updateGain,
    FindUserById findUserById,
    FindBankById findBankById,
    FindGainCategoryById findGainCategoryById
  ) {
    this.createGain = createGain;
    this.deleteGain = deleteGain;
    this.findAllGainsByUser = findAllGainsByUser;
    this.findGainById = findGainById;
    this.updateGain = updateGain;
    this.findUserById = findUserById;
    this.findBankById = findBankById;
    this.findGainCategoryById = findGainCategoryById;
  }

  @PostMapping
  public ResponseEntity<Object> save(@RequestBody GainRequestDto body) {
    var user = findUserById.showUser(body.userId());
    var bank = findBankById.showBank(body.bankId());
    var category = findGainCategoryById.show(body.gainCategoryId());
    var gain = new Gain();
    gain.setUser(user);
    gain.setBank(bank);
    gain.setGainCategory(category);
    gain.setDate(Instant.parse(body.date()));
    gain.setDescription(body.description());
    gain.setValue(body.value());
    return ResponseEntity.status(201).body(createGain.saveGain(gain));
  }
  
  @GetMapping("/list/{userId}")
  public ResponseEntity<Object> list(@PathVariable("userId") Integer userId) {
      return ResponseEntity.ok(findAllGainsByUser.findAllGains(userId));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Object> show(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(findGainById.show(id));
  }
  
  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody GainRequestDto body) {
    var user = findUserById.showUser(body.userId());
    var bank = findBankById.showBank(body.bankId());
    var category = findGainCategoryById.show(body.gainCategoryId());
    var gain = new Gain();
    gain.setId(id);
    gain.setUser(user);
    gain.setBank(bank);
    gain.setGainCategory(category);
    gain.setDate(Instant.parse(body.date()));
    gain.setDescription(body.description());
    gain.setValue(body.value());;
    return ResponseEntity.ok(updateGain.updateGain(gain));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
    deleteGain.deleteGain(id);
    return ResponseEntity.noContent().build();
  }
}
