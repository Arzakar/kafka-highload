package org.klimashin.kafka.consumer.controller;

import org.klimashin.kafka.consumer.api.dto.CatTransactionCreationRequestDto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatTransactionController {

    CatTransaction

    public UUID createTransaction(CatTransactionCreationRequestDto creationRequest) {

    }
}
