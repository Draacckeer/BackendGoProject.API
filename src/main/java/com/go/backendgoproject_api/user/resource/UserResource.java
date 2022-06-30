package com.go.backendgoproject_api.user.resource;
import lombok.*;


@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String username;
    private String password;
    private String vote;
}
