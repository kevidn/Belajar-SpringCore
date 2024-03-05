package com.kevidn.repository;

import com.kevidn.domain.Account;

public interface AccountRepository {

    public void update(Account account);

    public Account find(Long id);

}
