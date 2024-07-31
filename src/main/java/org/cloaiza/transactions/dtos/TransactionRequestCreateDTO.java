package org.cloaiza.transactions.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequestCreateDTO {
    @NotNull
    TransactionDTO transaction;
}
