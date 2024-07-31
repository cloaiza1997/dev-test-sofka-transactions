package org.cloaiza.transactions.dtos;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {
  @NotNull
  private Long transactionId;
  @NotNull
  private Date timestamp;
  @NotNull
  private String deviceNumber;
  @NotNull
  private Long userId;
  @NotNull
  private TransactionGeoPositionDTO geoPosition;
  @NotNull
  private Double amount;
}
