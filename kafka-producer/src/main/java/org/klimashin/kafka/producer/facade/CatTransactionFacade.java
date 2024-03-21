package org.klimashin.kafka.producer.facade;

import org.klimashin.kafka.producer.api.dto.CatTransactionCreationRequestDto;
import org.klimashin.kafka.producer.model.async.CatTransactionMessage;
import org.klimashin.kafka.producer.model.entity.CatTransaction;
import org.klimashin.kafka.producer.model.entity.TransactionDirectionType;
import org.klimashin.kafka.producer.service.CatTransactionService;
import org.klimashin.kafka.producer.service.stream.MessageProducer;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatTransactionFacade {

    CatTransactionService catTransactionService;
    MessageProducer messageProducer;
    TransactionTemplate transactionTemplate;

    public CatTransaction createTransaction(CatTransactionCreationRequestDto creationRequest) {
        var customerId = creationRequest.getCustomerId();
        var direction = TransactionDirectionType.valueOf(creationRequest.getDirection().name());
        var catMass = creationRequest.getCatMass();
        var catColor = creationRequest.getCatColor();

        return transactionTemplate.execute(status -> {
            var createdTransaction = catTransactionService.createTransaction(customerId, direction, catMass, catColor);
            var transactionMessage = CatTransactionMessage.builder()
                    .id(createdTransaction.getId())
                    .customerId(createdTransaction.getCustomerId())
                    .direction(CatTransactionMessage.TransactionDirection.valueOf(createdTransaction.getDirection().name()))
                    .catMass(createdTransaction.getCatMass())
                    .catColor(createdTransaction.getCatColor())
                    .build();
            messageProducer.send(transactionMessage);

            return createdTransaction;
        });
    }
}
