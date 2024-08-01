package org.cloaiza.transactions.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.bson.types.ObjectId;

@MongoEntity(collection = "transaction_daily_summaries")
@Getter
@Setter
@ToString
public class TransactionDailySummary extends ReactivePanacheMongoEntity {

    private ObjectId id;
    private Date date;
    private Integer totalTransactions;
    private Double totalAmount;
}
