package com.go.backendgoproject_api.user.api;

import com.go.backendgoproject_api.user.domain.service.UserService;
import com.go.backendgoproject_api.user.mapping.UserMapper;
import com.go.backendgoproject_api.user.resource.CreateUserResource;
import com.go.backendgoproject_api.user.resource.UpdateUserResource;
import com.go.backendgoproject_api.user.resource.UserResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User")
@RestController
@RequestMapping("api/v1/users")
@CrossOrigin(origins = "*" , maxAge = 3600)
public class UsersController {

    private final UserService userService;

    private final UserMapper mapper;

    public UsersController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }


    @Operation(summary = "Get All Users", description = "Get All Users")
    @GetMapping
    public List<UserResource> getAll(){
        return mapper.toResource(userService.getAll());
    }

    @Operation(summary = "Get User by Id", description = "Get User by Id")
    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable Long userId){
        return mapper.toResource(userService.getById(userId));
    }

    @Operation(summary = "Create New User", description = "Create New User")
    @PostMapping
    public UserResource createUser(@RequestBody CreateUserResource resource) {
        return mapper.toResource(userService.create(mapper.toModel(resource)));
    }
    @Operation(summary = "Update User", description = "Update User")
    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId,
                                       @RequestBody UpdateUserResource resource){
        return mapper.toResource(userService.update(userId, mapper.toModel(resource)));
    }

    @Operation(summary = "Delete User", description = "Delete User")
    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        return userService.delete(userId);
    }

}