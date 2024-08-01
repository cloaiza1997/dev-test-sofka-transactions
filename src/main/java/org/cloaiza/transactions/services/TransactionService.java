package org.cloaiza.transactions.services;

import org.bson.Document;
import org.cloaiza.transactions.dtos.TransactionDTO;
import org.cloaiza.transactions.mappers.TransactionMapper;
import org.cloaiza.transactions.models.Transaction;
import org.cloaiza.transactions.models.TransactionDailySummary;
import org.cloaiza.transactions.repositories.TransactionRepository;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.mongodb.client.result.InsertOneResult;

import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransactionService {
  @Inject
  ReactiveMongoClient mongoClient;

  @Inject
  TransactionRepository transactionRepository;

  @ConfigProperty(name = "quarkus.mongodb.database")
  private String database;

  public Uni<InsertOneResult> addTransactionV1(TransactionDTO transaction) {

    Document document = new Document()
        .append("transactionId", transaction.getTransactionId())
        .append("timestamp", transaction.getTimestamp())
        .append("deviceNumber", transaction.getDeviceNumber())
        .append("userId", transaction.getUserId())
        .append("geoPosition", transaction.getGeoPosition())
        .append("amount", transaction.getAmount());

    return mongoClient
        .getDatabase(database)
        .getCollection("transactions")
        .insertOne(document);
  }

  public Uni<Transaction> addTransactionV2(TransactionDTO transactionDTO) {

    Transaction transaction = TransactionMapper.INSTANCE.transactionDTOToTransaction(transactionDTO);

    return transactionRepository.persist(transaction);
  }

  public Uni<TransactionDailySummary> getTransactionDailySummary(String summaryDate) {
    return transactionRepository.getTransactionDailySummary(summaryDate);
  }
}
