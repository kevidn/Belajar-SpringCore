package com.kevidn.service;

import java.math.BigDecimal;

import com.kevidn.domain.Account;

public interface AccountService {

    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance);

    public Account getAccount(Long id);
}
