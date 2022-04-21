package com.jake.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jake.models.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account,Integer> {

}
