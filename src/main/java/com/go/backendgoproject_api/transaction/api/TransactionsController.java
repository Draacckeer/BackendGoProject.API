package com.go.backendgoproject_api.transaction.api;


import com.go.backendgoproject_api.transaction.domain.service.TransactionService;
import com.go.backendgoproject_api.transaction.mapping.TransactionMapper;
import com.go.backendgoproject_api.transaction.resource.CreateTransactionResource;
import com.go.backendgoproject_api.transaction.resource.TransactionResource;
import com.go.backendgoproject_api.transaction.resource.UpdateTransactionResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction")
@RestController
@RequestMapping("api/v1/transactions")
@CrossOrigin(origins = "*" , maxAge = 3600)
public class TransactionsController {

    private final TransactionService transactionService;

    private final TransactionMapper mapper;

    public TransactionsController(TransactionService transactionService, TransactionMapper mapper) {
        this.transactionService = transactionService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Transactions", description = "Get All Transactions")
    @GetMapping
    public List<TransactionResource> getAll(){
        return mapper.toResource(transactionService.getAll());
    }

    @Operation(summary = "Get Transaction by Id", description = "Get Transaction by Id")
    @GetMapping("{transactionId}")
    public TransactionResource getTransactionById(@PathVariable Long transactionId){
        return mapper.toResource(transactionService.getById(transactionId));
    }

    @Operation(summary = "Create New Transaction", description = "Create New Transaction")
    @PostMapping
    public TransactionResource createTransaction(@RequestBody CreateTransactionResource resource) {
        return mapper.toResource(transactionService.create(mapper.toModel(resource)));
    }
    @Operation(summary = "Update Transaction", description = "Update Transaction")
    @PutMapping("{transactionId}")
    public TransactionResource updateTransaction(@PathVariable Long transactionId,
                                   @RequestBody UpdateTransactionResource resource){
        return mapper.toResource(transactionService.update(transactionId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete Transaction", description = "Delete Transaction")
    @DeleteMapping("{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId){
        return transactionService.delete(transactionId);
    }

}