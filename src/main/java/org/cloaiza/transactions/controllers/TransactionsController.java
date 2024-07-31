package org.cloaiza.transactions.controllers;

import io.smallrye.mutiny.Uni;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;

import org.cloaiza.core.constants.CoreConstants;
import org.cloaiza.core.dtos.HttpResponseDTO;
import org.cloaiza.transactions.dtos.TransactionRequestCreateDTO;

@Slf4j
@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionsController {

    @POST
    public Uni<HttpResponseDTO> addTransaction(@Valid TransactionRequestCreateDTO transactionRequestCreateDTO) {
        HttpResponseDTO response = new HttpResponseDTO(CoreConstants.TRANSACTION_CREATE_OK);

        log.info(CoreConstants.TRANSACTION_CREATE_OK);

        return Uni.createFrom().item(response);
    }
}
