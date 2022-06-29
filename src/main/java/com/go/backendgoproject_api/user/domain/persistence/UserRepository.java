package com.go.backendgoproject_api.user.domain.persistence;

import com.go.backendgoproject_api.user.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
