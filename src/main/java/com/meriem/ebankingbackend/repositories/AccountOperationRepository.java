package com.meriem.ebankingbackend.repositories;

import com.meriem.ebankingbackend.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
