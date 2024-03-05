package com.kevidn.repository.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.kevidn.domain.Account;
import com.kevidn.repository.AccountRepository;

public class AccountRepositoryImpl implements AccountRepository{

    private Map<Long, Account> accountMap = new HashMap<Long, Account>();
    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setAccountNumber("001");
        account1.setBalance(new BigDecimal(15000000));
        account1.setName("Kevin");

        Account account2 = new Account();
        account2.setId(2L);
        account2.setAccountNumber("002");
        account2.setBalance(new BigDecimal(5000000));
        account2.setName("Dzaky");

        Account account3 = new Account();
        account3.setId(3L);
        account3.setAccountNumber("003");
        account3.setBalance(new BigDecimal(25000000));
        account3.setName("Hendra");

        accountMap.put(account1.getId(), account1);
        accountMap.put(account2.getId(), account2);
        accountMap.put(account3.getId(), account3);
    }

    @Override
    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account find(Long id) {
        return accountMap.get(id);
    }

}
