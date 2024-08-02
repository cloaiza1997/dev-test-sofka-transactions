package org.cloaiza.transactions.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import org.cloaiza.core.constants.CoreConstants;
import org.cloaiza.core.dtos.HttpResponseDTO;
import org.cloaiza.core.utils.LogUtils;
import org.cloaiza.transactions.dtos.TransactionRequestCreateDTO;
import org.cloaiza.transactions.services.TransactionService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Path("/v1/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionController {

    @Inject
    TransactionService transactionService;

    @POST
    @Operation(summary = "Servicio de creación de transacciones", description = "Registra una transacción en la base de datos y luego emite el mensaje al broker de mensajería.")
    public Uni<HttpResponseDTO> addTransactionV2(@Valid TransactionRequestCreateDTO transactionRequestCreateDTO) {
        return transactionService
                .addTransactionV2(transactionRequestCreateDTO.getTransaction())
                .onItem()
                .transform(result -> {
                    LogUtils.info(CoreConstants.TRANSACTION_CREATE_OK);

                    return new HttpResponseDTO(result, CoreConstants.TRANSACTION_CREATE_OK);
                })
                .onFailure()
                .recoverWithItem(e -> {
                    LogUtils.error(CoreConstants.TRANSACTION_CREATE_ERROR, e);

                    return new HttpResponseDTO(false, CoreConstants.TRANSACTION_CREATE_ERROR);
                });
    }

    @GET
    @Path("/summary/{date}")
    @Operation(summary = "Servicio de generación de reporte por fecha", description = "De acuerdo con la fecha enviada como parámetro se consultan las solicitudes de ese día para sumar el valor total diario por transacción, dicho resultado se registra en la base de datos. Como el reporte es diario, se genera un registro único por día. En caso de no existir transacciones según la fecha indicada, se genera un registro por valor de 0 para dejar trazabilidad de que en ese día no hubieron transacciones. Este servicio es utilizado para la tarea programada de generación diaria del reporte.")
    public Uni<HttpResponseDTO> getTransactionDailySummary(
            @PathParam("date") @Schema(example = "2024-07-31") String date) {

        return transactionService
                .getTransactionDailySummary(date)
                .onItem()
                .transform(result -> {
                    String message = result == null
                            ? CoreConstants.TRANSACTION_SUMMARY_EMPTY
                            : CoreConstants.TRANSACTION_SUMMARY_OK;

                    LogUtils.info(message);

                    return new HttpResponseDTO(result, message);
                })
                .onFailure()
                .recoverWithItem(e -> {
                    LogUtils.error(CoreConstants.TRANSACTION_SUMMARY_ERROR, e);

                    return new HttpResponseDTO(false, CoreConstants.TRANSACTION_SUMMARY_ERROR);
                });
    }
}
