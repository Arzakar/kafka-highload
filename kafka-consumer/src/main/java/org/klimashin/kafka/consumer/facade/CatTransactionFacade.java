package org.klimashin.kafka.consumer.facade;

import org.klimashin.kafka.consumer.api.dto.CatTransactionCreationRequestDto;
import org.klimashin.kafka.consumer.model.entity.CatTransaction;
import org.klimashin.kafka.consumer.model.entity.TransactionDirection;
import org.klimashin.kafka.consumer.service.CatTransactionService;
import org.klimashin.kafka.consumer.service.stream.MessageProducer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatTransactionFacade {

    CatTransactionService catTransactionService;
    MessageProducer messageProducer;

    public CatTransaction createTransaction(CatTransactionCreationRequestDto creationRequest) {
        var customerId = creationRequest.getCustomerId();
        var direction = TransactionDirection.valueOf(creationRequest.getDirection().name());
        var catMass = creationRequest.getCatMass();
        var catColor = creationRequest.getCatColor();

        var createdTransaction = catTransactionService.createTransaction(customerId, direction, catMass, catColor);


        return catTransactionService.createTransaction(customerId, direction, catMass, catColor);
    }
}
