package com.go.backendgoproject_api.user.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateUserResource {
    private Long id;

    private String username;


    private String password;

    private Number money;
}