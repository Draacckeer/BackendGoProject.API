package com.go.backendgoproject_api.block.mapping;

import com.go.backendgoproject_api.block.domain.model.entity.Block;
import com.go.backendgoproject_api.block.resource.BlockResource;
import com.go.backendgoproject_api.block.resource.CreateBlockResource;
import com.go.backendgoproject_api.block.resource.UpdateBlockResource;
import com.go.backendgoproject_api.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BlockMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public BlockResource toResource(Block model){
        return mapper.map(model, BlockResource.class);
    }

    public java.util.List<BlockResource> toResource(java.util.List<Block> model){
        return mapper.mapList(model, BlockResource.class);
    }

    public Block toModel(CreateBlockResource resource){
        return mapper.map(resource, Block.class);
    }
    public Block toModel(UpdateBlockResource resource){
        return mapper.map(resource, Block.class);
    }
    public Page<BlockResource> modelListToPage(List<Block> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, BlockResource.class), pageable, modelList.size());
    }
}