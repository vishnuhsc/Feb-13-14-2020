package com.hss.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hss.entities.Statement;

public interface StatementRepository extends CrudRepository<Statement, Integer> {

}
