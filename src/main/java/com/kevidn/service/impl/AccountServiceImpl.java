package com.kevidn.service.impl;

import java.math.BigDecimal;

import com.kevidn.domain.Account;
import com.kevidn.repository.AccountRepository;
import com.kevidn.service.AccountService;

public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Override
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance) {
        Account sourceAccount = accountRepository.find(sourceId);
        Account destinationAccount = accountRepository.find(destinationId);
        sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
        destinationAccount.setBalance(destinationAccount.getBalance().add(balance));

        accountRepository.update(sourceAccount);
        accountRepository.update(destinationAccount);
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.find(id);
    }


}
