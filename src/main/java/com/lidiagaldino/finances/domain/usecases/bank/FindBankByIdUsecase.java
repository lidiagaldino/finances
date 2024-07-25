package com.lidiagaldino.finances.domain.usecases.bank;

import com.lidiagaldino.finances.domain.entities.Bank;

public interface FindBankByIdUsecase {
  Bank showBank(Integer id);
}
