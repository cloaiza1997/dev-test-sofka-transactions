package org.cloaiza.transactions.mappers;

import org.cloaiza.transactions.dtos.TransactionDailySummaryDTO;
import org.cloaiza.transactions.models.TransactionDailySummary;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionDailySummaryMapper {

  TransactionDailySummaryMapper INSTANCE = Mappers.getMapper(TransactionDailySummaryMapper.class);

  TransactionDailySummary dtoToEntity(TransactionDailySummaryDTO transactionDailySummaryDTO);

  TransactionDailySummaryDTO entityToDto(TransactionDailySummary transactionDailySummary);
}
