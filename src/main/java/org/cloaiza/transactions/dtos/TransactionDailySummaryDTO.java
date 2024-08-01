package org.cloaiza.transactions.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.bson.types.ObjectId;

@Getter
@Setter
@ToString
public class TransactionDailySummaryDTO {

    private ObjectId id;
    private Date date;
    private Integer totalTransactions;
    private Double totalAmount;
}
