package com.go.backendgoproject_api.transaction.domain.service;

import com.go.backendgoproject_api.transaction.domain.model.entity.Transaction;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAll();
    Transaction getById(Long transactionId);
    Transaction create(Transaction transaction);
    Transaction update(Long transactionId, Transaction transaction);
    ResponseEntity<?> delete(Long transactionId);
}
