package com.go.backendgoproject_api.block.api;


import com.go.backendgoproject_api.block.domain.service.BlockService;
import com.go.backendgoproject_api.block.mapping.BlockMapper;
import com.go.backendgoproject_api.block.resource.BlockResource;
import com.go.backendgoproject_api.block.resource.CreateBlockResource;
import com.go.backendgoproject_api.block.resource.UpdateBlockResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Block")
@RestController
@RequestMapping("api/v1/blocks")
@CrossOrigin(origins = "*" , maxAge = 3600)
public class BlocksController {

    private final BlockService blockService;

    private final BlockMapper mapper;

    public BlocksController(BlockService blockService, BlockMapper mapper) {
        this.blockService = blockService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Blocks", description = "Get All Blocks")
    @GetMapping
    public List<BlockResource> getAll(){
        return mapper.toResource(blockService.getAll());
    }

    @Operation(summary = "Get Block by Id", description = "Get Block by Id")
    @GetMapping("{blockId}")
    public BlockResource getBlockById(@PathVariable Long blockId){
        return mapper.toResource(blockService.getById(blockId));
    }

    @Operation(summary = "Create New Block", description = "Create New Block")
    @PostMapping
    public BlockResource createBlock(@RequestBody CreateBlockResource resource) {
        return mapper.toResource(blockService.create(mapper.toModel(resource)));
    }
    @Operation(summary = "Update Block", description = "Update Block")
    @PutMapping("{blockId}")
    public BlockResource updateBlock(@PathVariable Long blockId,
                                                 @RequestBody UpdateBlockResource resource){
        return mapper.toResource(blockService.update(blockId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete Block", description = "Delete Block")
    @DeleteMapping("{blockId}")
    public ResponseEntity<?> deleteBlock(@PathVariable Long blockId){
        return blockService.delete(blockId);
    }

}