package com.go.backendgoproject_api.block.domain.service;

import com.go.backendgoproject_api.block.domain.model.entity.Block;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BlockService {
    List<Block> getAll();
    Block getById(Long blockId);
    Block create(Block block);
    Block update(Long blockId, Block block);
    ResponseEntity<?> delete(Long blockId);
}
