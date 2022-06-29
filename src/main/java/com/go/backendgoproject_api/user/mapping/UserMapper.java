package com.go.backendgoproject_api.user.mapping;

import com.go.backendgoproject_api.shared.mapping.EnhancedModelMapper;
import com.go.backendgoproject_api.user.domain.model.entity.User;
import com.go.backendgoproject_api.user.resource.CreateUserResource;
import com.go.backendgoproject_api.user.resource.UpdateUserResource;
import com.go.backendgoproject_api.user.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

    public java.util.List<UserResource> toResource(java.util.List<User> model){
        return mapper.mapList(model, UserResource.class);
    }

    public User toModel(CreateUserResource resource){
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }

    public Page<UserResource> modelListToPage(List<User> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}