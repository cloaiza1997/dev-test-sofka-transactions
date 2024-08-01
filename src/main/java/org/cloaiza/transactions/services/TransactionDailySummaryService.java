package org.cloaiza.transactions.services;

import org.cloaiza.transactions.dtos.TransactionDailySummaryDTO;
import org.cloaiza.transactions.mappers.TransactionDailySummaryMapper;
import org.cloaiza.transactions.models.TransactionDailySummary;
import org.cloaiza.transactions.repositories.TransactionDailySummaryRepository;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TransactionDailySummaryService {

  @Inject
  TransactionDailySummaryRepository transactionDailySummaryRepository;

  /**
   * Before to persist, it deletes existing documents to guarantee only one
   * document by date
   */
  public Uni<TransactionDailySummaryDTO> addTransactionDailySummary(
      TransactionDailySummaryDTO transactionDailySummaryDTO) {

    TransactionDailySummary transactionDailySummary = TransactionDailySummaryMapper.INSTANCE
        .dtoToEntity(transactionDailySummaryDTO);

    return transactionDailySummaryRepository
        .deleteByDate(transactionDailySummary.getDate())
        .onItem()
        .transformToUni(result -> transactionDailySummaryRepository.persist(transactionDailySummary))
        .onItem()
        .transform(TransactionDailySummaryMapper.INSTANCE::entityToDto);
  }
}
