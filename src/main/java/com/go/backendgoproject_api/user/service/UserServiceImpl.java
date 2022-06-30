package com.go.backendgoproject_api.user.service;


import com.go.backendgoproject_api.shared.exception.ResourceNotFoundException;
import com.go.backendgoproject_api.shared.exception.ResourceValidationException;
import com.go.backendgoproject_api.user.domain.model.entity.User;
import com.go.backendgoproject_api.user.domain.persistence.UserRepository;
import com.go.backendgoproject_api.user.domain.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll(){return userRepository.findAll();}

    @Override
    public User getById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User create(User user) {
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        try{
            return userRepository.save(user);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving user");
        }
    }
    @Override
    public User update(Long userId, User request){
        Set<ConstraintViolation<User>> violations = validator.validate(request);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        try{
            return userRepository.findById(userId)
                    .map(user->
                            userRepository.save(
                                    user.withUsername(request.getUsername())
                                            .withPassword(request.getPassword())
                                            .withVote(request.getVote())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating user");
        }
    }

    @Override
    public ResponseEntity<?> delete(Long userId) {
        return userRepository.findById(userId).map(user -> {
            userRepository.delete(user);
                    return ResponseEntity.ok().build();
                }
        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));
    }

}