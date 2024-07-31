package org.cloaiza.transactions.dtos;

import java.util.Date;

import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO {
    private ObjectId id;
    @NotNull
    @Schema(example = "123")
    private Long transactionId;
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "America/Bogota")
    @Schema(example = "2024-07-03 12:34:56.789")
    private Date timestamp;
    @NotNull
    @Schema(example = "456")
    private String deviceNumber;
    @NotNull
    @Schema(example = "789")
    private Long userId;
    @NotNull
    private TransactionGeoPositionDTO geoPosition;
    @NotNull
    @Schema(example = "987.65")
    private Double amount;
}
