package org.cloaiza.transactions.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionGeoPositionDTO {
  @NotNull
  private Double latitude;
  @NotNull
  private Double longitude;
}
