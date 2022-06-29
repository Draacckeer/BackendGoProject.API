package com.go.backendgoproject_api.transaction.resource;

import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransactionResource {
    private Long userSender;
    private Long userReceiver;
    private Number money;

}
