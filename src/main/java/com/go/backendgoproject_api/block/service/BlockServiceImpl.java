package com.go.backendgoproject_api.block.service;


import com.go.backendgoproject_api.block.domain.model.entity.Block;
import com.go.backendgoproject_api.block.domain.persistence.BlockRepository;
import com.go.backendgoproject_api.block.domain.service.BlockService;
import com.go.backendgoproject_api.shared.exception.ResourceNotFoundException;
import com.go.backendgoproject_api.shared.exception.ResourceValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class BlockServiceImpl implements BlockService {
    private static final String ENTITY = "Block";
    private final BlockRepository blockRepository;

    private final Validator validator;

    public BlockServiceImpl(BlockRepository blockRepository, Validator validator) {
        this.blockRepository = blockRepository;
        this.validator = validator;
    }

    @Override
    public List<Block> getAll(){return blockRepository.findAll();}

    @Override
    public Block getById(Long blockId){
        return blockRepository.findById(blockId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, blockId));
    }

    @Override
    public Block create(Block block) {
        Set<ConstraintViolation<Block>> violations = validator.validate(block);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        try{
            return blockRepository.save(block);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving block");
        }
    }
    @Override
    public Block update(Long blockId, Block request){
        Set<ConstraintViolation<Block>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        try{
            return blockRepository.findById(blockId)
                    .map(block->
                            blockRepository.save(
                                    block.withData(request.getData())
                                            .withHash(request.getHash())
                                            .withPrevHash(request.getPrevHash())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, blockId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating block");
        }
    }
    @Override
    public ResponseEntity<?> delete(Long blockId) {
        return blockRepository.findById(blockId).map(block -> {
            blockRepository.delete(block);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, blockId));
    }

}