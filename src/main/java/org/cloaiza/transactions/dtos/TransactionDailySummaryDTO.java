package org.cloaiza.transactions.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import org.bson.types.ObjectId;
import org.cloaiza.core.constants.CoreConstants;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonFormat;

@Getter
@Setter
@ToString
public class TransactionDailySummaryDTO {
    @Schema(hidden = true)
    private ObjectId id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = CoreConstants.TIMEZONE)
    private Date date;
    private Integer totalTransactions;
    private Double totalAmount;
}
