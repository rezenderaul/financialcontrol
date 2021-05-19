package com.raulrezende.financialcontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raulrezende.financialcontrol.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

}
