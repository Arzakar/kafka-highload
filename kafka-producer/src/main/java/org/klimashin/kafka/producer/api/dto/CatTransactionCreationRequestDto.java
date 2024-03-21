package org.klimashin.kafka.producer.api.dto;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class CatTransactionCreationRequestDto {

    UUID customerId;

    TransactionDirectionDto direction;

    Integer catMass;

    String catColor;


    public enum TransactionDirectionDto {

        INCOMING, OUTGOING
    }
}
