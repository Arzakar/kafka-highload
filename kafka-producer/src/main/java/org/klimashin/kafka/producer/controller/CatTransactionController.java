package org.klimashin.kafka.producer.controller;

import org.klimashin.kafka.producer.api.CatTransactionApi;
import org.klimashin.kafka.producer.api.dto.CatTransactionCreationRequestDto;
import org.klimashin.kafka.producer.facade.CatTransactionFacade;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatTransactionController implements CatTransactionApi {

    CatTransactionFacade catTransactionFacade;

    @Override
    public UUID createTransaction(CatTransactionCreationRequestDto creationRequest) {
        return catTransactionFacade.createTransaction(creationRequest).getId();
    }
}
