package org.cloaiza.transactions.dtos;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionGeoPositionDTO {
  @NotNull
  @Schema(example = "3.451647")
  private Double latitude;
  @NotNull
  @Schema(example = "-76.531982")
  private Double longitude;
}
