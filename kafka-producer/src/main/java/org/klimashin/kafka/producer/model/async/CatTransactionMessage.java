package org.klimashin.kafka.producer.model.async;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

@Value
@Builder
@Jacksonized
@EqualsAndHashCode(callSuper = false)
public class CatTransactionMessage extends AbstractMessage {

    UUID id;
    UUID customerId;
    TransactionDirection direction;
    Integer catMass;
    String catColor;

    @Override
    @JsonIgnore
    public String getTopicName() {
        return "cat-transaction";
    }

    public enum TransactionDirection {
        INCOMING, OUTGOING
    }
}
