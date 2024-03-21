package org.klimashin.kafka.producer.service;

import org.klimashin.kafka.producer.model.entity.CatTransaction;
import org.klimashin.kafka.producer.model.entity.TransactionDirectionType;
import org.klimashin.kafka.producer.repository.CatTransactionRepository;

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

    public CatTransaction createTransaction(UUID customerId, TransactionDirectionType direction, Integer catMass, String catColor) {
        var catTransaction = new CatTransaction()
                .setCustomerId(customerId)
                .setDirection(direction)
                .setCatMass(catMass)
                .setCatColor(catColor);

        return catTransactionRepository.save(catTransaction);
    }
}
