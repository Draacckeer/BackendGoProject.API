package com.go.backendgoproject_api.block.resource;

import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBlockResource {
    private Long id;
    private String hash;

    private String data;

    private String prevHash;
}