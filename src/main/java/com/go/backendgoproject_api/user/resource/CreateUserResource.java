package com.go.backendgoproject_api.user.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResource {

    private String username;


    private String password;

    private Long tokens;
}