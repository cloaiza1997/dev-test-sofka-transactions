package org.cloaiza.transactions.mappers;

import org.cloaiza.transactions.dtos.TransactionDTO;
import org.cloaiza.transactions.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  Transaction dtoToEntity(TransactionDTO transactionDTO);

  TransactionDTO entityToDto(Transaction transaction);
}
