package org.klimashin.kafka.consumer.service;

import org.klimashin.kafka.consumer.model.entity.OutboxMessage;
import org.klimashin.kafka.consumer.repository.OutboxMessageRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OutboxMessageService {

    OutboxMessageRepository outboxMessageRepository;

    public OutboxMessage createMessage(byte[] payload) {
        var message = new OutboxMessage()
                .setPayload(payload);

        return outboxMessageRepository.save(message);
    }

    public void deleteMessage(UUID id) {
        outboxMessageRepository.deleteById(id);
    }
}
