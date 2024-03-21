package org.klimashin.kafka.consumer.service.stream;

import org.klimashin.kafka.consumer.model.async.AbstractMessage;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessageProducer {

    StreamBridge streamBridge;

    public void send(AbstractMessage abstractMessage) {
        streamBridge.send()
    }
}
