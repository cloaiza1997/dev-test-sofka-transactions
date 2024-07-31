package org.cloaiza.transactions.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

import org.bson.types.ObjectId;

@MongoEntity(collection = "transactions")
@Getter
@Setter
public class Transaction extends ReactivePanacheMongoEntity {

    private ObjectId id;
    private Long transactionId;
    private Date timestamp;
    private String deviceNumber;
    private Long userId;
    private TransactionGeoPosition geoPosition;
    private Double amount;
}
