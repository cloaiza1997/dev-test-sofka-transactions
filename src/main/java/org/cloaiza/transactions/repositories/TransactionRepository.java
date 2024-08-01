package org.cloaiza.transactions.repositories;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.cloaiza.transactions.dtos.TransactionDailySummaryDTO;
import org.cloaiza.transactions.models.Transaction;

import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Field;
import com.mongodb.client.model.Filters;

@ApplicationScoped
public class TransactionRepository implements ReactivePanacheMongoRepository<Transaction> {
  /**
   * 
   * <pre>
   * // MongoDB query
   * db.transactions.aggregate([
   *  {
   *    $match: {
   *      $expr: {
   *        $eq: [
   *          { $dateToString: { format: "%Y-%m-%d", date: "$timestamp" } },
   *          "2024-07-31",
   *        ],
   *      },
   *    },
   *  },
   *  {
   *    $group: {
   *      _id: null,
   *      totalTransactions: { $sum: 1 },
   *      totalAmount: { $sum: "$amount" },
   *    },
   *  },
   *  {
   *    $addFields: {
   *      date: "2024-07-31",
   *    },
   *  },
   * ]);
   * </pre>
   */
  public Uni<TransactionDailySummaryDTO> getTransactionDailySummary(String summaryDate) {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    Date date;

    try {
      date = formatter.parse(summaryDate);
    } catch (ParseException e) {
      return Uni.createFrom().failure(e);
    }

    Bson match = Aggregates.match(
        Filters.expr(
            new Document(
                "$eq", Arrays.asList(
                    new Document("$dateToString",
                        new Document("format", "%Y-%m-%d")
                            .append("date", "$timestamp")),
                    summaryDate))));

    Bson group = Aggregates.group(
        null,
        Accumulators.sum("totalTransactions", 1),
        Accumulators.sum("totalAmount", "$amount"));

    Bson addFields = Aggregates.addFields(new Field<Date>("date", date));

    return mongoCollection()
        .aggregate(Arrays.asList(match, group, addFields), TransactionDailySummaryDTO.class)
        .toUni();
  }
}
