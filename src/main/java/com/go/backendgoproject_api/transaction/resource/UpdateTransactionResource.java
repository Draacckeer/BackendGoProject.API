package com.go.backendgoproject_api.transaction.resource;
import lombok.*;

@Setter
@Getter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransactionResource {
    private Long id;
    private Long userSender;
    private Long userReceiver;
    private Number money;
}
