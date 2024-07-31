package org.cloaiza.transactions.mappers;

import org.cloaiza.transactions.dtos.TransactionDTO;
import org.cloaiza.transactions.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  // TransactionDTO to Transaction
  Transaction transactionDTOToTransaction(TransactionDTO transactionDTO);

  // Transaction to TransactionDTO
  TransactionDTO transactionToTransactionDTO(Transaction transaction);
}
