package org.klimashin.kafka.producer.api;

import org.klimashin.kafka.producer.api.dto.CatTransactionCreationRequestDto;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

public interface CatTransactionApi {

    @PostMapping(value = "/api/v1/cat-transactions")
    UUID createTransaction(CatTransactionCreationRequestDto creationRequest);
}
