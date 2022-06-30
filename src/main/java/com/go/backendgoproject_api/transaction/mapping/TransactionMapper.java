package com.go.backendgoproject_api.transaction.mapping;

import com.go.backendgoproject_api.shared.mapping.EnhancedModelMapper;
import com.go.backendgoproject_api.transaction.domain.model.entity.Transaction;
import com.go.backendgoproject_api.transaction.resource.CreateTransactionResource;
import com.go.backendgoproject_api.transaction.resource.TransactionResource;
import com.go.backendgoproject_api.transaction.resource.UpdateTransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TransactionMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public TransactionResource toResource(Transaction model){
        return mapper.map(model, TransactionResource.class);
    }

    public java.util.List<TransactionResource> toResource(java.util.List<Transaction> model){
        return mapper.mapList(model, TransactionResource.class);
    }

    public Transaction toModel(CreateTransactionResource resource){
        return mapper.map(resource, Transaction.class);
    }
    public Transaction toModel(UpdateTransactionResource resource){
        return mapper.map(resource, Transaction.class);
    }
    public Page<TransactionResource> modelListToPage(List<Transaction> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, TransactionResource.class), pageable, modelList.size());
    }
}