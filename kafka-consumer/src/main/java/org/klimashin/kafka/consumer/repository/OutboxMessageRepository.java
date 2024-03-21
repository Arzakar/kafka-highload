package org.klimashin.kafka.consumer.repository;

import org.klimashin.kafka.consumer.model.entity.OutboxMessage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutboxMessageRepository extends JpaRepository<OutboxMessage, UUID> {
}
