package com.go.backendgoproject_api.transaction.service;

import com.go.backendgoproject_api.shared.exception.ResourceNotFoundException;
import com.go.backendgoproject_api.shared.exception.ResourceValidationException;
import com.go.backendgoproject_api.transaction.domain.model.entity.Transaction;
import com.go.backendgoproject_api.transaction.domain.persistence.TransactionRepository;
import com.go.backendgoproject_api.transaction.domain.service.TransactionService;
import com.go.backendgoproject_api.user.domain.model.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final String ENTITY = "Transaction";
    private final TransactionRepository transactionRepository;

    private final Validator validator;

    public TransactionServiceImpl(TransactionRepository transactionRepository,  Validator validator) {
        this.transactionRepository = transactionRepository;
        this.validator = validator;
    }

    @Override
    public List<Transaction> getAll(){return transactionRepository.findAll();}

    @Override
    public Transaction getById(Long transactionId){
        return transactionRepository.findById(transactionId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, transactionId));
    }

    @Override
    public Transaction create(Transaction transaction) {
        Set<ConstraintViolation<Transaction>> violations = validator.validate(transaction);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        try{
            return transactionRepository.save(transaction);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving transaction");
        }
    }
    @Override
    public Transaction update(Long transactionId, Transaction request){
        Set<ConstraintViolation<Transaction>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        try{
            return transactionRepository.findById(transactionId)
                    .map(transaction->
                            transactionRepository.save(
                                    transaction.withUserSender(request.getUserSender())
                                            .withUserReceiver(request.getUserReceiver())
                                            .withMoney(request.getMoney())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, transactionId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating transaction");
        }
    }
    @Override
    public ResponseEntity<?> delete(Long transactionId) {
        return transactionRepository.findById(transactionId).map(transaction -> {
            transactionRepository.delete(transaction);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, transactionId));
    }

}