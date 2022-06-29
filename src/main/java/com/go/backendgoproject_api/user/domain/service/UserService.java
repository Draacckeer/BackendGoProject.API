package com.go.backendgoproject_api.user.domain.service;

import com.go.backendgoproject_api.user.domain.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getById(Long userId);
    User create(User user);
    User update(Long userId, User user);
    ResponseEntity<?> delete(Long userId);
}
