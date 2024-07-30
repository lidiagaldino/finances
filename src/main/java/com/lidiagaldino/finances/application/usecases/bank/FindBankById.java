package com.lidiagaldino.finances.application.usecases.bank;

import org.springframework.stereotype.Service;

import com.lidiagaldino.finances.domain.entities.Bank;
import com.lidiagaldino.finances.domain.exceptions.NotFoundException;
import com.lidiagaldino.finances.domain.repositories.BankRepository;
import com.lidiagaldino.finances.domain.usecases.bank.FindBankByIdUsecase;

@Service
public class FindBankById implements FindBankByIdUsecase {
  private final BankRepository bankRepository;

  public FindBankById(BankRepository bankRepository) {
    this.bankRepository = bankRepository;
  }

  public Bank showBank(Integer id) {
    var bank = bankRepository.show(id);
    if(bank.isEmpty()) throw new NotFoundException("BANK");
    return bank.get();
  }
}
