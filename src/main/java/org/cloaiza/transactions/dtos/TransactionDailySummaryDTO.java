package org.cloaiza.transactions.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
@ToString
public class TransactionDailySummaryDTO {
    @Schema(hidden = true)
    private ObjectId id;
    private Date date;
    private Integer totalTransactions;
    private Double totalAmount;
}
