package org.klimashin.kafka.consumer.service;

import org.klimashin.kafka.consumer.model.entity.CatTransaction;
import org.klimashin.kafka.consumer.model.entity.TransactionDirection;
import org.klimashin.kafka.consumer.repository.CatTransactionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CatTransactionService {

    CatTransactionRepository catTransactionRepository;

    public CatTransaction createTransaction(UUID customerId, TransactionDirection direction, Integer catMass, String catColor) {
        var catTransaction = new CatTransaction()
                .setCustomerId(customerId)
                .setDirection(direction)
                .setCatMass(catMass)
                .setCatColor(catColor);

        return catTransactionRepository.save(catTransaction);
    }
}
