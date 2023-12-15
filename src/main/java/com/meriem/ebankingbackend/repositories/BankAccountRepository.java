package com.meriem.ebankingbackend.repositories;

import com.meriem.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
