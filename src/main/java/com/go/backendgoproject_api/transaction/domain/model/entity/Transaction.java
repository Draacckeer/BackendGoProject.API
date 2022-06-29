package com.go.backendgoproject_api.transaction.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.go.backendgoproject_api.shared.domain.model.AuditModel;
import com.go.backendgoproject_api.user.domain.model.entity.User;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "transactions")
public class Transaction extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userSender;

    private Long userReceiver;

    private Number money;

}
