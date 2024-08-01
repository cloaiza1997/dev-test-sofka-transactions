package org.cloaiza.transactions.repositories;

import java.util.Date;

import javax.xml.crypto.dsig.spec.XPathType.Filter;

import org.cloaiza.transactions.models.TransactionDailySummary;

import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TransactionDailySummaryRepository implements ReactivePanacheMongoRepository<TransactionDailySummary> {
  public Uni<DeleteResult> deleteByDate(Date date) {
    return mongoCollection().deleteMany(Filters.eq("date", date));
  }
}
