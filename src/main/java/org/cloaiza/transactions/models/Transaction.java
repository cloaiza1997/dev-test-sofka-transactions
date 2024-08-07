package org.cloaiza.transactions.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.bson.types.ObjectId;

@MongoEntity(collection = "transactions")
@Getter
@Setter
@ToString
public class Transaction extends ReactivePanacheMongoEntity {

    private ObjectId id;
    private Long transactionId;
    private Date timestamp;
    private String deviceNumber;
    private Long userId;
    private TransactionGeoPosition geoPosition;
    private Double amount;

    @Getter
    @Setter
    public static class TransactionGeoPosition {
        private Double latitude;
        private Double longitude;
    }
}
