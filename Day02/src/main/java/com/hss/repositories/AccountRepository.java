package com.hss.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hss.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
