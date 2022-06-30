package com.go.backendgoproject_api.block.domain.persistence;

import com.go.backendgoproject_api.block.domain.model.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
}
