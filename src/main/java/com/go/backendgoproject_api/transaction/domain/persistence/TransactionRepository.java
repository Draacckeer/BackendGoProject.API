package com.go.backendgoproject_api.transaction.domain.persistence;

import com.go.backendgoproject_api.transaction.domain.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
