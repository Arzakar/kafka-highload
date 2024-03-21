package org.klimashin.kafka.consumer.api.dto;

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
}
